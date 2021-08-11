package com.example.demo.example.text;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对文本框的替换，对文本框的替换，不是正常输入的文本，是插入的文本框
 */
public class TextBox {

    public static List<String> patternList = new ArrayList();

    //需要处理的节点名称
    static {
        patternList.add("mc:AlternateContent");
        patternList.add("mc:Choice");
        patternList.add("w:drawing");
        patternList.add("wp:anchor");
        patternList.add("a:graphic");
        patternList.add("a:graphicData");
        patternList.add("wps:wsp");
        patternList.add("wps:txbx");
        patternList.add("w:txbxContent");
        patternList.add("w:p");
        patternList.add("w:r");
        patternList.add("w:t");
    }

    public static void main(String[] args) throws Exception {

        final String returnurl = "D:\\youxi\\jx\\textbox.docx";  // 结果文件
        final String templateurl = "D:\\GIT_PROJECT\\poi-demo\\poi-demo\\src\\main\\resources\\textbox.docx";  // 模板文件

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

        // 文本数据
        Map<String, String> textMap = new HashMap<String, String>();
        textMap.put("texttext", "我是被替换的普通文本内容");
        textMap.put("name", "我是被替换的文本框内容");
        textMap.put("zuoyou", "左右");

        changeTextBox(doc, textMap);

    }


    public static void changeTextBox(XWPFDocument document, Map<String, String> map) {
        for (XWPFParagraph paragraph : document.getParagraphs())
            for (XmlObject object : paragraph.getCTP().getRArray()) {
                XmlCursor cursor = object.newCursor();
                eachchild(cursor, 0, map);
            }
    }


    public static void eachchild(XmlCursor cursor, int start, Map<String, String> map) {
        for (int i = 0; i < 10; i++) {
            if (cursor.toChild(i)) {
                if (cursor.getDomNode().getNodeName().equals(patternList.get(start))) {
                    if (start == patternList.size() - 1) {
                        String reString = cursor.getTextValue();
                        System.out.println(reString);
                        reString = reString.replaceAll("\\{\\{", "").replaceAll("}}", "");

                        for (String e : map.keySet()) {
                            if (reString.equals(e)) {
                                //    执行替换
                                reString = reString.replaceAll(e, map.get(e));
                            }
                        }
                        cursor.setTextValue(reString);
                    }
                    eachchild(cursor, start + 1, map);
                } else {
                    cursor.toParent();
                }
            }
        }

        cursor.toParent();
    }


}





















