package com.example.demo.httpclient.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.example.demo.httpclient.VO.Apartment;
import com.example.demo.httpclient.VO.SimpleVO;
import io.netty.channel.ConnectTimeoutException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleServiceImpl implements SimpleService {
    private final Logger log = LoggerFactory.getLogger(SimpleServiceImpl.class);


    @Override
    public Map<String, Object> getDocument(HttpServletRequest request) {
        //获取对应的部门,需要查数据库，这里应该是XXXMapper.getXX()
        List<Apartment> apartments = new ArrayList<>();

        //造数
        Apartment a = new Apartment();
        a.setCode("110000");
        a.setName("北京市");
        a.setUrl("http://");
        Apartment b = new Apartment();
        a.setCode("120000");
        a.setName("天津市");
        a.setUrl("http://");
        Apartment c = new Apartment();
        a.setCode("130000");
        a.setName("河北省");
        a.setUrl("http://");
        Apartment d = new Apartment();
        a.setCode("140000");
        a.setName("山西省");
        a.setUrl("http://");

        apartments.add(a);
        apartments.add(b);
        apartments.add(c);
        apartments.add(d);

        Object params = new Object();
        //获取url
        List<String> urls = apartments.stream()
                .filter(Objects::nonNull)
                .parallel()
                .map(apart -> {
                    if (apart.getUrl() != null) {
                        return apart.getUrl();
                    }
                    return null;
                })
                .collect(Collectors.toList());

        //
        List<List<SimpleVO>> datas = urls.stream()
                .filter(Objects::nonNull)
                .parallel()
                .map(url -> ayncHttpPostToOthers(request, url, params))
                .collect(Collectors.toList());

        List<SimpleVO> simpleVOS = new ArrayList<>();
        List<SimpleVO> simpleVOSNew = new ArrayList<>();

        /*
          将所有返回的数据整合到一起，而不是在各个list中
          这一步很重要
         */
        datas.forEach(data->{
            assert data.size() > 0;
            simpleVOS.addAll(data);
        });

        /*
            最难的代码就是这里，重要的是思想
         */
        simpleVOS.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(SimpleVO::getDocumentId))
                .forEach((id, groupList) -> groupList.stream().reduce((a1, b1) -> {
                    SimpleVO vo = new SimpleVO();
                    vo.setBeforeUseNum(a1.getBeforeUseNum() + b1.getBeforeUseNum());
                    vo.setDocumentId(a1.getDocumentId());
                    vo.setBeforeUseNum(a1.getBeforeUseNum() + b1.getBeforeRowNum());
                    return vo;
                }).ifPresent(simpleVOSNew::add));

        Map<String, Object> map = new HashMap<>();
        map.put("data", simpleVOSNew);
        return map;
    }

    private List<SimpleVO> ayncHttpPostToOthers(HttpServletRequest request, String url, Object params) {
        //失败重试机制
        HttpRequestRetryHandler retryHandler = (e, i, httpContext) -> {
            log.error("retryRequest:{}", i);
            if (i > 3) return false;
            if (e instanceof ConnectTimeoutException ||
                    e instanceof NoHttpResponseException ||
                    e instanceof UnknownHostException ||
                    e instanceof InterruptedIOException ||
                    e instanceof SSLException) {
                return true;
            } else {
                log.error("未记录的请求异常：{}", e.getClass());
            }
            HttpClientContext clientContext = HttpClientContext.adapt(httpContext);
            HttpRequest httpRequest = clientContext.getRequest();
            return !(httpRequest instanceof HttpEntityEnclosingRequest);
        };

        List<SimpleVO> simpleVOS = new ArrayList<>();

        try (CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(retryHandler).build()) {
            //设置请求路径，请求格式
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Cookie", request.getCookies()[0].getValue());
            httpPost.setHeader("Content-type",
                    "application/json;charset=UTF-8");
            //格式化请求参数
            String parameter = JSONUtils.toJSONString(params);
            StringEntity stringEntity = new StringEntity(parameter);
            stringEntity.setContentType("text/json");
            httpPost.setEntity(stringEntity);

            //设置超时，连接超时和传输超时
            RequestConfig build = RequestConfig.custom().setConnectTimeout(1000).setSocketTimeout(10000).build();
            httpPost.setConfig(build);

            //
            try (CloseableHttpResponse execute = httpClient.execute(httpPost)) {
                if (200 == execute.getStatusLine().getStatusCode()) {

                    String p = EntityUtils.toString(execute.getEntity());
                    HashMap<String, Object> map = JSON.parseObject(p, HashMap.class);
                    // json obj
                    if (200 == (Integer) map.get("code")) {
                        //
                        Object data = map.get("data");
                        if (data == null) {
                            log.error("返回数据空：{}", url);
                        } else {
                            //要将data转化为simplevo对象
                            simpleVOS.add(new SimpleVO());
                        }

                    } else log.error("获取数据出错：{}", map);
                } else log.error("获取地址出错：{}", url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return simpleVOS;
    }

}
