package com.example.demo.example.barchart;

import com.example.demo.util.PoiWordTools;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.xwpf.usermodel.XWPFChart;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 实现图表的精准定位实现图表的精准定位实现图表的精准定位
 */
public class BarChartLocation {

    public static void main(String[] args) throws Exception {

        final String returnurl = "C:\\Users\\gt136\\Downloads\\Compressed\\poi-demo-master\\poi-demo\\src\\main\\output\\result.docx";  // 结果文件
        final String templateurl = "C:\\Users\\gt136\\Downloads\\Compressed\\poi-demo-master\\poi-demo\\src\\main\\output\\test.docx";  // 模板文件

        InputStream is = new FileInputStream(templateurl);
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
        // 获取word模板中的所有图表元素，用map存放:获取到了所有图表的模板，分别为charX和title
        // 为什么不用list保存：查看doc.getRelations()的源码可知，源码中使用了hashMap读取文档图表元素，
        // 对relations变量进行打印后发现，图表顺序和文档中的顺序不一致，也就是说relations的图表顺序不是文档中从上到下的顺序
        Map<String, POIXMLDocumentPart> chartsMap = new HashMap<>();
        //动态刷新图表
        List<POIXMLDocumentPart> relations = doc.getRelations();
        for (POIXMLDocumentPart poixmlDocumentPart : relations) {
            if (poixmlDocumentPart instanceof XWPFChart) {  // 如果是图表元素
                String str = poixmlDocumentPart.toString();
                System.out.println("str: "+str);
                // 获取图表对应的表格数据里面的第一行第一列数据，可以拿来当作key值
                String key = PoiWordTools.getZeroData(poixmlDocumentPart).trim();

                System.out.println("key：" + key);

                chartsMap.put(key, poixmlDocumentPart);
            }
        }

        System.out.println("\n图表数量：" + chartsMap.size() + "\n");

        // 第一个图表-柱状图
        doCharts1(chartsMap);

    }


    public static void  doCharts1(Map<String, POIXMLDocumentPart> chartsMap) {
        // 数据准备
        List<String> titleArr = new ArrayList<>();// 标题
        titleArr.add("");
        titleArr.add("存款");
        titleArr.add("存款22");
        titleArr.add("存款33");

        List<String> fldNameArr = new ArrayList<>();// 字段名(数据有多少列，就多少个)
        fldNameArr.add("item1");
        fldNameArr.add("item2");
        fldNameArr.add("item3");
        fldNameArr.add("item4");

        // 数据集合
        List<Map<String, String>> listItemsByType = new ArrayList<>();

        // 数据的话随便整都行

        // 第一行数据
        Map<String, String> base1 = new HashMap<>();
        base1.put("item1", "2020-01");
        base1.put("item2", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base1.put("item3", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base1.put("item4", (int)(1 + Math.random() * (100 - 1 + 1)) + "");

        // 第二行数据
        Map<String, String> base2 = new HashMap<>();
        base2.put("item1", "2020-02");
        base2.put("item2", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base2.put("item3", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base2.put("item4", (int)(1 + Math.random() * (100 - 1 + 1)) + "");

        // 第三行数据
        Map<String, String> base3 = new HashMap<>();
        base3.put("item1", "2020-03");
        base3.put("item2", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base3.put("item3", (int)(1 + Math.random() * (100 - 1 + 1)) + "");
        base3.put("item4", (int)(1 + Math.random() * (100 - 1 + 1)) + "");

        listItemsByType.add(base1);
        listItemsByType.add(base2);
        listItemsByType.add(base3);

        // 注意这里的key值
        /*
         * ""    -> {XWPFChart@1953}    "Name: /word/charts/chart6.xml - Content Type: application/vnd.openxmlformats-officedocument.drawingml.chart+xml"
         * char1 -> {XWPFChart@1955}    "Name: /word/charts/chart1.xml - Content Type: application/vnd.openxmlformats-officedocument.drawingml.chart+xml"
         * title -> {XWPFChart@1957}    "Name: /word/charts/chart4.xml - Content Type: application/vnd.openxmlformats-officedocument.drawingml.chart+xml"
         */
        POIXMLDocumentPart poixmlDocumentPart = chartsMap.get("char1");
        PoiWordTools.replaceBarCharts(poixmlDocumentPart, titleArr, fldNameArr, listItemsByType);
    }


}
















