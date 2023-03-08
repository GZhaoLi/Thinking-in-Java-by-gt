package com.gui.demo.thingInJava.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 正确读取和打印数据：text 和 ByteBuffers 互转
 * @Date 2021/12/10 9:41v
 * @Created by gt136
 */
public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        String name = "data2.txt";
        //获取输出通道
        try (FileChannel fc = new FileOutputStream(name).getChannel()){
            //通过 wrap 往缓冲中存入数据，并通过通道写入数据
            fc.write(ByteBuffer.wrap("Some Text".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //对于只读访问，必须用静态方法 allocate 分配大小
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        System.out.println(buff.limit());

        try (FileChannel fc = new FileInputStream(name).getChannel()) {
            //读取缓存大小的缓存，此外还必须调用 flip 来准备好提取字节，之后还得 clear 缓冲区
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        //无法运行
        System.out.println(buff.asCharBuffer());
        //使用默认系统编码解码
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": "
                + Charset.forName(encoding).decode(buff));

        //编码和打印
        try (FileChannel fc = new FileOutputStream(name).getChannel()) {
            fc.write(ByteBuffer.wrap("Some Text".getBytes(StandardCharsets.UTF_16BE)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //尝试再次读取
        buff.clear();
        try (FileChannel fc = new FileInputStream(name).getChannel()) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //
        buff.flip();
        System.out.println(buff.asCharBuffer());
        //通过 CharBuffer 写入：
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");

        try (FileChannel fc = new FileOutputStream(name).getChannel()){
            fc.write(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //读取和显示
        buff.clear();

        try (FileChannel fc = new FileInputStream(name).getChannel()) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
/*
outputs:
卯浥⁔數
Decoded using UTF-8: Some Text
Some Text
Some text
 */