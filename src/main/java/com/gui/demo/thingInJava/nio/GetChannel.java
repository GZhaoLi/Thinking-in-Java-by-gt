package com.gui.demo.thingInJava.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
   FileChannel 和 ByteBuffer 的使用
 * @Date 2021/12/4 23:01
 * @Created by gt136
 */
public class GetChannel {
    private static String name = "data.txt";
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        /*
        try-with-resource 是用来对外部资源进行自动回收的功能：如对数据库连接、网络连接和输入输出等，它解决了 try-catch-finally 的繁琐
        try() 括号中存放需要关闭的外部资源，这些资源必然是实现了 Closeable 或者 AutoCloseable 接口，以便自动调用 close 方法关闭资源；
        catch 捕获异常
        这个语法是一个语法糖，底层还是 try-with-resource，但是它帮我们简化了代码
         */
        //写入一个文件：FileChannel 的操作相当基础：操作 ByteBuffer 来用于读写，并独占式访问和锁定文件区域(稍后将对此进行描述)。
        try (FileChannel fc = new FileOutputStream(name).getChannel()){
            //将字节放入 ByteBuffer 的一种方式是直接调用 put()，也可以是其他基本数据类型。还可以通过下面的 wrap() 方法包装
            // 现有字节数组到 ByteBuffer。执行此操作时并不会复制底层数组，而是将其生成缓冲区存储，但对缓冲区的修改也会修改对应
            // 数组，这样的缓冲区叫数组“支持”的。
            fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 在文件尾添加;data.txt文件被 RandomAccessFile 重新打开
        try (FileChannel fc = new RandomAccessFile(name, "rw").getChannel()){
            //移动到结尾，注意：你可以在文件中移动 channel，在这里它被移动到末尾，以便添加额外的写操作
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("Some more".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //读取文件e
        try (FileChannel fc = new FileInputStream(name).getChannel()) {
            /*对于只读访问，必须使用静态 allocate（分配）方法显式的分配 ByteBuffer。
             NIO 的目标是快速移动大量数据，因此 ByteBuffer（字节缓冲区）的大小应该很重要————实际上，这里设置
             的 1k 都可能偏小了，我们工作中应该反复测试以找到最佳大小。
             通过使用 allocateDirect() 可以生成与操作系统具备更高耦合性的“直接缓冲区”，也有可能获得更高的速度。
             然而，这种分配的开销更大，而且因操作系统不同效果也不尽相同，因而在工作中必须再次测试。
             */
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);
            /*
            调用 read() 方法将字节数据存储到字节缓冲区中，你还必须调用缓冲区上的 flip() 方法来准备好提取字节（听起来有
            点粗糙，实际上已经是为了达到最高速度而进行的非常底层的操作
            如果要进一步调用 read() 来使用 ByteBuffer，还需要每次 clear() 来准备缓冲区。下个示例演示
             */
            fc.read(buff);
            buff.flip();
            while (buff.hasRemaining()) {
                System.out.println(buff.get());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.flush();
    }
}
/*
outputs:每个数字占一行，为了节省空间写作一行
83 111 109 101 32 116 101 120 116 32 83 111 109 101 32 109 111 114 101
//对应的 data.txt 中的数据为：
Some text Some more
 */