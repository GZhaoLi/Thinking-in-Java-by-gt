package com.gui.demo.thingInJava.Files.standardio;

import java.io.PrintWriter;

/**
 * @Classname ChangeSystemOut
 * @Description 将 System.out 转换成 PrintWriter
 * @Date 2021/9/13 11:14
 * @Created by gt136
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        //System.out 是一个 PrintStream，也就是 OutputStream。而PrintWriter有一个将 outputStream 作为
        // 参数的构造器。第二个参数设置为true是为了可以看到打印输出
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello,World");
    }
}
