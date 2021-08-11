package com.example.demo.example.other;


import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 更新模板word中的内置Excel数据
 * 代码参考了poi官网文档的api示例
 * poi官方api：http://poi.apache.org/components/document/quick-guide-xwpf.html
 * 官方示例源码：http://svn.apache.org/repos/asf/poi/trunk/src/examples/src/org/apache/poi/xwpf/usermodel/examples/UpdateEmbeddedDoc.java
 */
public class UpdateEmbeddedDoc {

    private static final String templateurl = "C:\\Users\\gt136\\Downloads\\Compressed\\poi-demo-master\\poi-demo\\src\\main\\output\\test.docx";  // 模板文件
    private static final String returnurl = "C:\\Users\\gt136\\Downloads\\Compressed\\poi-demo-master\\poi-demo\\src\\main\\output\\result.docx";  // 结果文件
    private XWPFDocument doc; // 模板文档对象
    private File docFile;
    private static final int SHEET_NUM = 0;   // xls中的sheet页数
    private static List<Map<String, String>> dataList = new ArrayList<>();   // 模拟数据

    static {
        // 模拟数据
        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("index-0", "老王吧" + i);
            map.put("index-1", "老李吧" + i);
            map.put("index-2", "老张吧" + i);
            map.put("index-3", "老刘吧" + i);
            map.put("index-4", "老杨吧" + i);
            map.put("index-5", "老乌龟吧" + i);

            dataList.add(map);
        }
    }


    public static void main(String[] args) throws Exception {
        UpdateEmbeddedDoc ued = new UpdateEmbeddedDoc(templateurl);
        ued.updateEmbeddedDoc();
    }

    /**
     * 构造函数，加载模板文档
     * @param filename
     * @throws IOException
     */
    public UpdateEmbeddedDoc(String filename) throws IOException {
        this.docFile = new File(filename);
        if (!this.docFile.exists()) {
            throw new FileNotFoundException("The Word document " + filename + " does not exist.");
        }
        try (FileInputStream fis = new FileInputStream(this.docFile)) {
            // Open the Word document file and instantiate the XWPFDocument class.
            this.doc = new XWPFDocument(fis);
        }
    }


    /**
     * 更新word文档中内置的Excel工作簿
     * Excel是事先已知的，并且在模板word中已经插入成功了的
     * @param filename
     * @throws IOException
     */
    public void updateEmbeddedDoc() throws Exception {
        // 获取模板文档中的内置部分，也就是获取到插入的Excel文档集合
        List<PackagePart> embeddedDocs = this.doc.getAllEmbeddedParts();
        for (PackagePart pPart :  embeddedDocs) {

            // 这里打印出来文档中所有的内置对象，可以看到每个内置对象都有一个唯一标识，通过这个标识可以做相应的业务逻辑；
            // 这里打印的oleFlag可能因为机器环境原因有所不同，建议先打印出oleFlag的值，对比后再做if判断；
            // 反正这里输出的内容看一下，就明白了；
            String oleFlag = pPart.toString();
            System.out.println(oleFlag);

            // 记得if中的条件“oleObject1”要和上面的oleFlag对比一下，能够唯一标识就好，我不敢保证每台机器的值都是“oleObject1”
            // 第一个内置对象，
            if (oleFlag.indexOf("oleObject1") > 0) {
                doXls1(pPart);

            } else if (oleFlag.indexOf("oleObject2") > 0) {
                doXls2(pPart); // 第二个内置对象，

            } else if (oleFlag.indexOf("oleObject3") > 0) {
                doXls3(pPart); // 第三个内置对象，

            }

            // TODO.......

        }

        if (!embeddedDocs.isEmpty()) {
            // Finally, write the newly modified Word document out to file.
            try (FileOutputStream fos = new FileOutputStream(returnurl)) {
                File file = new File(returnurl);
                if (file.exists()) {
                    file.delete();
                }
                this.doc.write(fos);
                fos.close();
            }
        }
    }


    /**
     * 第一个内置对象，数据的话自己造吧，这里我懒，用了一个数据
     * @param pPart
     * @throws Exception
     */
    public void doXls1(PackagePart pPart) throws Exception {
        try (InputStream is = pPart.getInputStream();
             Workbook workbook = WorkbookFactory.create(is);
             OutputStream os = pPart.getOutputStream()) {
            Sheet sheet = workbook.getSheetAt(SHEET_NUM);
            int ROW_NUM = 1;
            // 设置内置xlsx文件的数据，这里示例代码写的很傻瓜，看明白就好了；
            for (int i = 0; i < dataList.size(); i++) {
                Row row = sheet.createRow(ROW_NUM); // 创建行

                Map<String, String> colMap = dataList.get(i);
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(colMap.get("index-0")); // 第0列数据

                Cell cell1 = row.createCell(1);
                cell1.setCellValue(colMap.get("index-1")); // 第1列数据

                Cell cell2 = row.createCell(2);
                cell2.setCellValue(colMap.get("index-2")); // 第2列数据

                Cell cell3 = row.createCell(3);
                cell3.setCellValue(colMap.get("index-3")); // 第3列数据

                Cell cell4 = row.createCell(4);
                cell4.setCellValue(colMap.get("index-4")); // 第4列数据

                Cell cell5 = row.createCell(5);
                cell5.setCellValue(colMap.get("index-5")); // 第5列数据


                ROW_NUM++;
            }

            workbook.write(os);
        }
    }


    /**
     * 第二个内置对象，数据的话自己造吧，这里我懒，用了一个数据
     * @param pPart
     * @throws Exception
     */
    public void doXls2(PackagePart pPart) throws Exception {
        try (InputStream is = pPart.getInputStream();
             Workbook workbook = WorkbookFactory.create(is);
             OutputStream os = pPart.getOutputStream()) {
            Sheet sheet = workbook.getSheetAt(SHEET_NUM);
            int ROW_NUM = 1;
            // 设置内置xlsx文件的数据，这里示例代码写的很傻瓜，看明白就好了；
            for (int i = 0; i < dataList.size(); i++) {
                Row row = sheet.createRow(ROW_NUM); // 创建行

                Map<String, String> colMap = dataList.get(i);
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(colMap.get("index-0")); // 第0列数据

                Cell cell1 = row.createCell(1);
                cell1.setCellValue(colMap.get("index-1")); // 第1列数据

                Cell cell2 = row.createCell(2);
                cell2.setCellValue(colMap.get("index-2")); // 第2列数据

                Cell cell3 = row.createCell(3);
                cell3.setCellValue(colMap.get("index-3")); // 第3列数据

                Cell cell4 = row.createCell(4);
                cell4.setCellValue(colMap.get("index-4")); // 第4列数据

                Cell cell5 = row.createCell(5);
                cell5.setCellValue(colMap.get("index-5")); // 第5列数据


                ROW_NUM++;
            }

            workbook.write(os);
        }
    }


    /**
     * 第三个内置对象，数据的话自己造吧，这里我懒，用了一个数据
     * @param pPart
     * @throws Exception
     */
    public void doXls3(PackagePart pPart) throws Exception {
        try (InputStream is = pPart.getInputStream();
             Workbook workbook = WorkbookFactory.create(is);
             OutputStream os = pPart.getOutputStream()) {
            Sheet sheet = workbook.getSheetAt(SHEET_NUM);
            int ROW_NUM = 1;
            // 设置内置xlsx文件的数据，这里示例代码写的很傻瓜，看明白就好了；
            for (int i = 0; i < dataList.size(); i++) {
                Row row = sheet.createRow(ROW_NUM); // 创建行

                Map<String, String> colMap = dataList.get(i);
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(colMap.get("index-0")); // 第0列数据

                Cell cell1 = row.createCell(1);
                cell1.setCellValue(colMap.get("index-1")); // 第1列数据

                Cell cell2 = row.createCell(2);
                cell2.setCellValue(colMap.get("index-2")); // 第2列数据

                Cell cell3 = row.createCell(3);
                cell3.setCellValue(colMap.get("index-3")); // 第3列数据

                Cell cell4 = row.createCell(4);
                cell4.setCellValue(colMap.get("index-4")); // 第4列数据

                Cell cell5 = row.createCell(5);
                cell5.setCellValue(colMap.get("index-5")); // 第5列数据


                ROW_NUM++;
            }

            workbook.write(os);
        }
    }


}

















