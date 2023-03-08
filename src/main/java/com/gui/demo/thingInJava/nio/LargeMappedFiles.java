package com.gui.demo.thingInJava.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用内存映射来创建大文件
 *
 * @author chappyzhao
 * @Date 2021/12/17 15:37
 * @Created by gt136
 */
public class LargeMappedFiles {
    /**
     * 128M
     */
    static int length = 0x8000000;

    public static void main(String[] args) {
        //为了读写 使用 RandomAccessFile 开始获取文件通道，然后调用 map() 来生成 MapperByteBuffer
        // MapperByteBuffer是一种特殊的直接缓冲区。你必须指定要在文件中映射的区域的起始点和长度（意味着我们可以选择映射大文件的小区域）
        try (RandomAccessFile tdat = new RandomAccessFile("test.dat", "rw")) {
            // MapperByteBuffer 继承了 ByteBuffer，所以拥有 ByteBuffer 的全部方法
            MappedByteBuffer out = tdat.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
            for (int i = 0; i < length; i++) {
                out.put((byte) 'x');
            }
            System.out.println("Finished writing");
            for (int i = length / 2; i < length / 2 + 6; i++) {
                System.out.print((char)out.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
outputs:
Finished writing
xxxxxx
 */
