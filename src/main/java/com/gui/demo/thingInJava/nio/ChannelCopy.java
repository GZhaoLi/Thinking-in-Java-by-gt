package com.gui.demo.thingInJava.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
    通过缓冲区读取文件
 * @Date 2021/12/9 14:14
 * @Created by gt136
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("arguments: source-file destfile");
            System.exit(1);
        }

        try (FileChannel in = new FileInputStream(args[0]).getChannel();
            FileChannel out = new FileOutputStream(args[1]).getChannel()
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);//分配好存储
            //read() 将数据每次放入缓冲区中
            while (in.read(buffer) != -1) {
                //准备写入,每次都要准备好
                buffer.flip();
                out.write(buffer);
                //准备读取，在write() 之后，数据仍在缓冲区中，我们需要clear() 来重置所有内部指针，以便在下一次 read()中接受数据
                buffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
