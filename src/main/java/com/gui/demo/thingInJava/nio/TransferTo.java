package com.gui.demo.thingInJava.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 可能不会经常用到，但知道这一点很好
 * @Date 2021/12/9 14:50
 * @Created by gt136
 */
public class TransferTo {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("arguments: source-file destfile");
            System.exit(1);
        }
        try (FileChannel in = new FileInputStream(args[0]).getChannel();
             FileChannel out = new FileOutputStream(args[1]).getChannel()
        ) {
            in.transferTo(0, in.size(), out);
            //或者可以用下面的,这两个功能相同
            //out.transferFrom(in, 0, in.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
