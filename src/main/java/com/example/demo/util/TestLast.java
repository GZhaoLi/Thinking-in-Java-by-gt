package com.example.demo.util;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname TestLast
 * @Description TODO
 * @Date 2021/8/6 17:35
 * @Created by gt136
 */
public class TestLast {
    public static void toExcel(List<List<String>> statistics, String path) {

        XSSFWorkbook wb = null;//创建HSSFWorkbook对象
        try {
            wb = new XSSFWorkbook(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet1 = null;
        if (wb != null) {
            sheet1 = wb.getSheet("Sheet1");
        } else {
            System.out.println("未找到sheet");
            System.exit(0);
        }


        //写一个循环根据数据的数量来创建表格
        for (int i = 0; i < statistics.size(); i++) {
            if (i == 0) {
                continue;
            }
            XSSFRow row = null;
            if (i < sheet1.getPhysicalNumberOfRows()) {
                row = sheet1.getRow(i);
                for (int j = 0; j < statistics.get(i).size(); j++) {
                    if (j != 0) {
                        row.getCell(j).setCellValue(Integer.parseInt(statistics.get(i).get(j)));
                    } else {
                        row.getCell(j).setCellValue(String.valueOf(statistics.get(i).get(j)));
                    }
                }
            } else {
                row = sheet1.createRow(i);
                for (int j = 0; j < statistics.get(i).size(); j++) {
                    if (i != 0 && j != 0) {
                        row.createCell(j).setCellValue(Integer.parseInt(statistics.get(i).get(j)));
                    } else {
                        row.createCell(j).setCellValue(String.valueOf(statistics.get(i).get(j)));
                    }
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
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));
        statistics.add(Arrays.asList("财务部", "100"));


        toExcel(statistics, "C:\\Users\\gt136\\Downloads\\Compressed\\poi-demo-master\\poi-demo\\src\\main\\output\\result.xlsx");
    }

}
