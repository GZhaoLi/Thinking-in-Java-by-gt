package com.gui.demo.thingInJava.Files.appendixIO;

import java.io.*;

/**
 * @Classname StoringAndRecoveringData
 * @Description TODO
 * @Date 2021/9/10 17:44
 * @Created by gt136
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) {
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("Data.txt")
                ))
        ){
            out.writeDouble(3.1415926);
            out.writeUTF("That was pi");
            out.writeDouble(1.41413);
            out.writeUTF("Square root of 2");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("Data.txt")))
        ){
            System.out.println(in.readDouble());
            //只有readUTF()可以正确读出数据
            System.out.println(in.readUTF());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
outputs:
3.1415926
That was pi
1.41413
Square root of 2
 */
