package com.example.demo.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Excel2Util
 * @Description TODO
 * @Date 2021/8/5 17:28
 * @Created by gt136
 */
public class Excel2Util {
    /*public static void main(String[] args) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();//创建HSSFWorkbook对象

        HSSFSheet sheet=wb.createSheet("成绩表");//建立sheet对象

        HSSFRow row1=sheet.createRow(0); //在sheet里创建第一行，参数为行索引

        HSSFCell cell=row1.createCell(0); //创建单元格

        cell.setCellValue("人员统计表");        //设置单元格内容

        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列

        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));

        //在sheet里创建第二行

        HSSFRow row2=sheet.createRow(1);

        //创建单元格并设置单元格内容

        row2.createCell(0).setCellValue("部门");

        row2.createCell(1).setCellValue("人数");
*//*
        row2.createCell(2).setCellValue("语文成绩");

        row2.createCell(3).setCellValue("数学成绩");

        row2.createCell(4).setCellValue("英语成绩");*//*

        //在sheet里创建第三行

        HSSFRow row3=sheet.createRow(2);

        row3.createCell(0).setCellValue("平台研发中心");

        row3.createCell(1).setCellValue("8888");
*//*
        row3.createCell(2).setCellValue(80);

        row3.createCell(3).setCellValue(75);

        row3.createCell(4).setCellValue(88);*//*

        HSSFRow row4=sheet.createRow(3);

        row4.createCell(0).setCellValue("财务部");

        row4.createCell(1).setCellValue(90);
*//*
        row4.createCell(2).setCellValue(82);

        row4.createCell(3).setCellValue(70);

        row4.createCell(4).setCellValue(90);*//*

        //输出Excel文件

        File file;
        OutputStream output=new FileOutputStream("C:\\Users\\gt136\\Downloads\\Compressed\\poi-demo-master\\poi-demo\\src\\main\\output\\result.xlsx");

        wb.write(output);

        output.close();
    }*/

    public static void toExcel(List<List<String>> statistics, String path) {
        XSSFWorkbook wb = null;//创建HSSFWorkbook对象
        try {
            wb = new XSSFWorkbook(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet1 = wb.getSheet("Sheet1");
//        XSSFRow row11 = sheet0.getRow(2);
//        row11.getCell(2).setCellValue(1000);

//        XSSFSheet sheet = wb.createSheet("统计表");//建立sheet对象

        //写一个循环根据数据的数量来创建表格
        for (int i = 0; i < statistics.size(); i++) {
            XSSFRow row = sheet1.getRow(i + 2);

            for (int j = 0; j < statistics.get(i).size(); j++) {
                if(j!= 0){
                    row.getCell(j+1).setCellValue(Integer.parseInt(statistics.get(i).get(j)));
                } else {
                    row.getCell(2).setCellValue(String.valueOf(statistics.get(i).get(j)));
                }
            }
        }

        //输出Excel文件

        OutputStream output = null;
        try {
            output = new FileOutputStream(path);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            wb.write(output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        List<List<String>> statistics = new ArrayList<>();
        statistics.add(Arrays.asList("平台研发中心", "8"));
        statistics.add(Arrays.asList("财务部", "100"));
        toExcel(statistics,"C:\\Users\\gt136\\Downloads\\Compressed\\poi-demo-master\\poi-demo\\src\\main\\output\\result.xlsx");
    }

}
