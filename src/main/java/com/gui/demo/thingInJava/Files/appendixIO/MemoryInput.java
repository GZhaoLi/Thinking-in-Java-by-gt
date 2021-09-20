package com.gui.demo.thingInJava.Files.appendixIO;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Classname MemoryInput
 * @Description TODO
 * @Date 2021/9/10 16:48
 * @Created by gt136
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader sr = new StringReader(BufferedInputFile.read("src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\appendixIO\\MemoryInput.java"));
        int c;
        while ((c = sr.read()) != -1) {
            System.out.println((char) c);
        }
    }
}
