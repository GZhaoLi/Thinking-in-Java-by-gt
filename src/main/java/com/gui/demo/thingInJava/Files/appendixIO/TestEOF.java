package com.gui.demo.thingInJava.Files.appendixIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Classname TestEOF
 * @Description TestEOF
 * @Date 2021/9/10 17:15
 * @Created by gt136
 */
public class TestEOF {
    public static void main(String[] args) {
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\appendixIO\\TestEOF.java")
                )
        )) {
            //available() 返回in的数量
            while (in.available() != 0) {
                System.out.write(in.readByte());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
