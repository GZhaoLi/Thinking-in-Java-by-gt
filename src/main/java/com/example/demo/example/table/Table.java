package com.example.demo.example.table;

import com.example.demo.util.PoiWordTools;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表格，实现合并单元格，横竖都可以，方式1
 */
public class Table {

    public static void main(String[] args) throws Exception {

        final String returnurl = "D:\\youxi\\jx\\table1.docx";  // 结果文件
        final String templateurl = "D:\\POI\\demo\\src\\main\\resources\\table1.docx";  // 模板文件

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
     * @Description: 替换段落和表格中
     */
    public static void replaceAll(XWPFDocument doc) throws Exception {
        doParagraphs(doc); // 处理段落文字数据，包括文字和表格、图片
    }


    /**
     * 处理段落文字
     *
     * @param doc
     * @throws InvalidFormatException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void doParagraphs(XWPFDocument doc) throws Exception {
        /**----------------------------处理段落------------------------------------**/
        List<XWPFParagraph> paragraphList = doc.getParagraphs();
        if (paragraphList != null && paragraphList.size() > 0) {
            for (XWPFParagraph paragraph : paragraphList) {
                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                    String text = run.getText(0);
                    if (text != null) {

                        // 动态表格
                        if (text.contains("${table1}")) {
                            run.setText("", 0);
                            XmlCursor cursor = paragraph.getCTP().newCursor();
                            XWPFTable tableOne = doc.insertNewTbl(cursor);// ---这个是关键


                            // 设置表格宽度，第一行宽度就可以了，这个值的单位，目前我也还不清楚，还没来得及研究
                            tableOne.setWidth(8500);

                            // 表格第一行，对于每个列，必须使用createCell()，而不是getCell()，因为第一行嘛，肯定是属于创建的，没有create哪里来的get呢
                            XWPFTableRow tableOneRowOne = tableOne.getRow(0);//行
                            new PoiWordTools().setWordCellSelfStyle(tableOneRowOne.getCell(0), "微软雅黑", "9", 0, "left", "top", "#000000", "#B4C6E7", "10%", "序号");
                            new PoiWordTools().setWordCellSelfStyle(tableOneRowOne.createCell(), "微软雅黑", "9", 0, "left", "top", "#000000", "#B4C6E7", "45%", "公司名称(英文)");
                            new PoiWordTools().setWordCellSelfStyle(tableOneRowOne.createCell(), "微软雅黑", "9", 0, "left", "top", "#000000", "#B4C6E7", "45%", "公司名称(中文)");

                            for (int i = 0; i < 10; i ++) {
                                // 表格第二行
                                XWPFTableRow tableOneRowTwo = tableOne.createRow();//行
                                new PoiWordTools().setWordCellSelfStyle(tableOneRowTwo.getCell(0), "微软雅黑", "9", 0, "left", "top", "#000000", "#ffffff", "10%", "一行一列");
                                new PoiWordTools().setWordCellSelfStyle(tableOneRowTwo.getCell(1), "微软雅黑", "9", 0, "left", "top", "#000000", "#ffffff", "45%", "一行一列");
                                new PoiWordTools().setWordCellSelfStyle(tableOneRowTwo.getCell(2), "微软雅黑", "9", 0, "left", "top", "#000000", "#ffffff", "45%", "一行一列");
                            }


                            // 横着合并单元格  -----------------------------
                            CTHMerge cthMergeStart = CTHMerge.Factory.newInstance();
                            cthMergeStart.setVal(STMerge.RESTART);
                            CTHMerge cthMergeEnd = CTHMerge.Factory.newInstance();
                            cthMergeEnd.setVal(STMerge.CONTINUE);
                            XWPFTableCell cell71 = tableOne.getRow(6).getCell(0);  // 第7行的第1列
                            XWPFTableCell cell72 = tableOne.getRow(6).getCell(1);  // 第7行的第2列
                            XWPFTableCell cell73 = tableOne.getRow(6).getCell(2);  // 第7行的第3列

                            cell71.getCTTc().getTcPr().setHMerge(cthMergeStart);
                            cell72.getCTTc().getTcPr().setHMerge(cthMergeEnd);
                            cell73.getCTTc().getTcPr().setHMerge(cthMergeEnd);


                            // 竖着合并单元格   -----------------------------
                            CTVMerge vmergeStart = CTVMerge.Factory.newInstance();
                            vmergeStart.setVal(STMerge.RESTART);
                            CTVMerge vmergeEnd = CTVMerge.Factory.newInstance();
                            vmergeEnd.setVal(STMerge.CONTINUE);
                            XWPFTableCell cell1 = tableOne.getRow(1).getCell(0);  // 第2行第1列  第1行是表头
                            XWPFTableCell cell2 = tableOne.getRow(2).getCell(0);  // 第3行第1列
                            XWPFTableCell cell3 = tableOne.getRow(3).getCell(0);  // 第4行第1列
                            XWPFTableCell cell4 = tableOne.getRow(4).getCell(0);  // 第5行第1列


                            cell1.getCTTc().getTcPr().setVMerge(vmergeStart);
                            cell2.getCTTc().getTcPr().setVMerge(vmergeEnd);
                            cell3.getCTTc().getTcPr().setVMerge(vmergeEnd);
                            cell4.getCTTc().getTcPr().setVMerge(vmergeEnd);



                            // .......
                        }

                    }
                }
            }
        }
    }



}





















