package com.example.demo.example.barchart;

import com.example.demo.util.PoiWordTools;
import com.example.demo.util.PoiWordToolsDynamic;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.xwpf.usermodel.XWPFChart;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 动态的柱状图，也就是列不确定，由数据决定
 * 示例代码仅提供实现的参考，可根据自己的业务修改逻辑
 */
@Deprecated  // 对office有兼容问题，wps没问题，没解决，不建议使用
public class BarChartDynamic {

    public static void main(String[] args) throws Exception {

        final String returnurl = "D:\\youxi\\jx\\barchartdynamicresult.docx";  // 结果文件
        final String templateurl = "D:\\youxi\\jx\\barchartdynamic1.docx";  // 模板文件

        InputStream is = new FileInputStream(new File(templateurl));
        XWPFDocument doc = new XWPFDocument(is);

        // 替换word模板数据
        replaceAll(doc);

        // 保存结果文件
        try {
            File file = new File(returnurl);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(returnurl);
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @Description: 替换段落和表格和图表等内容
     */
    public static void replaceAll(XWPFDocument doc) throws Exception {
        doCharts(doc);  // 处理图表数据，柱状图
    }


    /**
     * 处理图表
     *
     * @param doc
     * @throws FileNotFoundException
     */
    public static void doCharts(XWPFDocument doc) throws FileNotFoundException {
        /**----------------------------处理图表------------------------------------**/
        // 获取word模板中的所有图表元素，用map存放
        // 为什么不用list保存：查看doc.getRelations()的源码可知，源码中使用了hashMap读取文档图表元素，
        // 对relations变量进行打印后发现，图表顺序和文档中的顺序不一致，也就是说relations的图表顺序不是文档中从上到下的顺序
        Map<String, POIXMLDocumentPart> chartsMap = new HashMap<String, POIXMLDocumentPart>();
        //动态刷新图表
        List<POIXMLDocumentPart> relations = doc.getRelations();
        for (POIXMLDocumentPart poixmlDocumentPart : relations) {
            if (poixmlDocumentPart instanceof XWPFChart) {  // 如果是图表元素

                // 获取图表对应的表格数据里面的第一行第一列数据，可以拿来当作key值
                String key = new PoiWordTools().getZeroData(poixmlDocumentPart).trim();

                System.out.println("key：" + key);

                chartsMap.put(key, poixmlDocumentPart);
            }
        }

        System.out.println("\n图表数量：" + chartsMap.size() + "\n");

        // 第一个图表-柱状图
        doCharts1(chartsMap);

        // 第一个图表-柱状图
        doCharts2(chartsMap);

    }


    /**
     * 封装图表数据
     * @param chartsMap
     */
    public static void doCharts1(Map<String, POIXMLDocumentPart> chartsMap) {
        // 数据准备
        List<String> titleArr = new ArrayList<String>();// 标题，也就是对图表选择编辑数据后显示的表格数据的第一行
        titleArr.add("");
        titleArr.add("存款$");
        titleArr.add("欠款$");
        titleArr.add("还款$");

        List<String> fldNameArr = new ArrayList<String>();// 字段名(数据有多少列，就多少个)
        fldNameArr.add("item1");
        fldNameArr.add("item2");
        fldNameArr.add("item3");
        fldNameArr.add("item4");

        // 数据集合
        List<Map<String, String>> listItemsByType = new ArrayList<Map<String, String>>();

        // 数据的话随便整都行

        // 第一行数据
        Map<String, String> base1 = new HashMap<String, String>();
        base1.put("item1", "2020-05");
        base1.put("item2", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base1.put("item3", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base1.put("item4", (int)(1 + Math.random() * (100 - 1 + 1)) + "");

        // 第二行数据
        Map<String, String> base2 = new HashMap<String, String>();
        base2.put("item1", "2020-06");
        base2.put("item2", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base2.put("item3", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base2.put("item4", (int)(1 + Math.random() * (100 - 1 + 1)) + "");

        // 第三行数据
        Map<String, String> base3 = new HashMap<String, String>();
        base3.put("item1", "2020-07");
        base3.put("item2", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base3.put("item3", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base3.put("item4", (int)(1 + Math.random() * (100 - 1 + 1)) + "");

        listItemsByType.add(base1);
        listItemsByType.add(base2);
        listItemsByType.add(base3);

        // 注意这里的key值
        POIXMLDocumentPart poixmlDocumentPart = chartsMap.get("嘻嘻嘻嘻");  // 图表对象
        new PoiWordToolsDynamic().replaceBarCharts(poixmlDocumentPart, titleArr, fldNameArr, listItemsByType);
    }



    public static void doCharts2(Map<String, POIXMLDocumentPart> chartsMap) {
        // 数据准备
        List<String> titleArr = new ArrayList<String>();// 标题，也就是对图表选择编辑数据后显示的表格数据的第一行
        titleArr.add("");
        titleArr.add("存款$");
        titleArr.add("欠款$");
        titleArr.add("还款$");

        List<String> fldNameArr = new ArrayList<String>();// 字段名(数据有多少列，就多少个)
        fldNameArr.add("item1");
        fldNameArr.add("item2");
        fldNameArr.add("item3");
        fldNameArr.add("item4");

        // 数据集合
        List<Map<String, String>> listItemsByType = new ArrayList<Map<String, String>>();

        // 数据的话随便整都行

        // 第一行数据
        Map<String, String> base1 = new HashMap<String, String>();
        base1.put("item1", "2020-05");
        base1.put("item2", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base1.put("item3", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base1.put("item4", (int)(1 + Math.random() * (100 - 1 + 1)) + "");

        // 第二行数据
        Map<String, String> base2 = new HashMap<String, String>();
        base2.put("item1", "2020-06");
        base2.put("item2", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base2.put("item3", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base2.put("item4", (int)(1 + Math.random() * (100 - 1 + 1)) + "");

        // 第三行数据
        Map<String, String> base3 = new HashMap<String, String>();
        base3.put("item1", "2020-07");
        base3.put("item2", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base3.put("item3", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base3.put("item4", (int)(1 + Math.random() * (100 - 1 + 1)) + "");

        listItemsByType.add(base1);
        listItemsByType.add(base2);
        listItemsByType.add(base3);

        // 注意这里的key值
        POIXMLDocumentPart poixmlDocumentPart = chartsMap.get("哈哈哈哈");  // 图表对象
        new PoiWordToolsDynamic().replaceLineCharts(poixmlDocumentPart, titleArr, fldNameArr, listItemsByType);
    }


}
















