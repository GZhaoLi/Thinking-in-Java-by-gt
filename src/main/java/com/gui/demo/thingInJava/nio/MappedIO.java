package com.gui.demo.thingInJava.nio;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * 文件映射读取对比
 * @Date 2021/12/19 14:22
 * @Created by gt136
 */
public class MappedIO {
    private static final int numOfInts = 4_000_000;
    private static final int numOfUbufferInts = 100_000;
    private abstract static class Tester{
        private String name;

        Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.print(name + ": ");
            long start = System.nanoTime();
            //计算的 I/O 的时间了包括了初始化对象的时间，通过结果可用看出：尽管映射文件的设置可能很昂贵，但是
            // 与 I/O 流相比，总体收益是相当可观的。
            test();
            long duration = System.nanoTime() - start;
            System.out.format("%.3f%n", duration / 1.0e9);
        }

        public abstract void test();
    }

    private static Tester[] tests = {
            new Tester("Stream Write") {
                @Override
                public void test() {
                    try (DataOutputStream dos =
                                 new DataOutputStream(
                                         new BufferedOutputStream(
                                                 new FileOutputStream("temp.tmp")))){
                        for (int i = 0; i < numOfInts; i++) {
                            dos.writeInt(i);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped Write") {
                @Override
                public void test() {
                    //虽然映射的写似乎该使用FileOutputStream，但是文件映射中的所有输出必须使用 RandomAccessFile
                    try(FileChannel fc = new RandomAccessFile("temp.tmp","rw")
                                        .getChannel()){
                        IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size())
                                .asIntBuffer();
                        for (int i = 0; i < numOfInts; i++) {
                            ib.put(i);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() {
                    try (DataInputStream dis =
                                 new DataInputStream(
                                         new BufferedInputStream(
                                                 new FileInputStream("temp.tmp")))) {
                        for (int i = 0; i < numOfInts; i++) {
                            dis.readInt();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped Read") {
                @Override
                public void test() {
                    try (FileChannel fc =
                                 new FileInputStream("temp.tmp").getChannel()) {
                        IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size())
                                .asIntBuffer();
                        while (ib.hasRemaining()) {
                            ib.get();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Stream Read/Write") {
                @Override
                public void test() {
                    try (RandomAccessFile raf =
                                 new RandomAccessFile("temp.tmp", "rw")) {
                        raf.writeInt(1);
                        for (int i = 0; i < numOfUbufferInts; i++) {
                            raf.seek(raf.length() - 4);
                            raf.writeInt(raf.readInt());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped Write/Read") {
                @Override
                public void test() {
                    try (FileChannel fc =
                                 new RandomAccessFile("temp.tmp", "rw")
                                         .getChannel()) {
                        IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size())
                                .asIntBuffer();
                        ib.put(0);
                        for (int i = 1; i < numOfUbufferInts; i++) {
                            ib.put(ib.get(i - 1));
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
    };

    public static void main(String[] args) {
        Arrays.stream(tests).forEach(Tester::runTest);
    }
}
/*
outputs:
Stream Write: 0.384
Mapped Write: 0.028
Stream Read: 0.613
Mapped Read: 0.018
Stream Read/Write: 4.340
Mapped Write/Read: 0.006

Mac Version
Stream Write: 0.174
Mapped Write: 0.029
Stream Read: 0.230
Mapped Read: 0.014
Stream Read/Write: 1.604
Mapped Write/Read: 0.006
 */

