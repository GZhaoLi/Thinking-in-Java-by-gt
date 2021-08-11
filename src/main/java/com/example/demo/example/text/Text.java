package com.example.demo.example.text;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 不好用，不好用，不好用，不好用，不好用，不好用
 * 纯文本替换，该示例主要解决XWPFRun分段的问题，不使用run.getText方法了，直接对段落进行替换
 * 但是这里会有缺陷，模板设置的格式不会生效
 */
public class Text {

    private static final String pattern = "\\{\\{+[a-zA-Z0-9]+\\}\\}";   // 拿到文本标签的正则表达式

    public static void main(String[] args) throws Exception {

        final String returnurl = "D:\\youxi\\jx\\text.docx";  // 结果文件
        final String templateurl = "D:\\POI\\demo\\src\\main\\resources\\text.docx";  // 模板文件

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
     * @Description: 替换段落
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
        textMap.put("text", "我是被替换的文本内容");
        textMap.put("name", "我是小帅哥");
        textMap.put("age", "我今年18岁");


        /**----------------------------处理段落------------------------------------**/
        List<XWPFParagraph> paragraphList = doc.getParagraphs();
        if (paragraphList != null && paragraphList.size() > 0) {
            for (XWPFParagraph paragraph : paragraphList) {
                String ptext = paragraph.getText();  // 段落文字

                System.out.println("段落文本：" + ptext);

                if (!StringUtils.isEmpty(ptext)) {
                    List<String> resList = resolver(ptext);  // 段落里面的标签
                    for (String flag : resList) {
                        String key = flag.replaceAll("\\{\\{", "").replaceAll("}}", "");
                        String label = textMap.get(key);
                        if (!StringUtils.isEmpty(label)) {
                            ptext = ptext.replace(flag, label);  // 替换段落文字
                        }
                    }
                }

                // 清除段落所有的run，解决run文字分段问题
                for (int i = 0; i < paragraph.getRuns().size(); i++) {
                    paragraph.removeRun(i);

                }
                // 主动添加一个run并设置文本内容
                paragraph.insertNewRun(0).setText(ptext);

            }
        }
    }


    /**
     * 解析段落，获取里面的标签
     */
    public static List<String> resolver(String line) {
        List<String> resList = new ArrayList<String>();
        try {
            Pattern patten = Pattern.compile(pattern);//编译正则表达式
            Matcher matcher = patten.matcher(line);// 指定要匹配的字符串
            while (matcher.find()) { //此处find（）每次被调用后，会偏移到下一个匹配
                String flag = matcher.group();

                resList.add(flag);
            }

            for (String str : resList) {
                System.out.println("标签："+str);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return resList;
    }



}


















