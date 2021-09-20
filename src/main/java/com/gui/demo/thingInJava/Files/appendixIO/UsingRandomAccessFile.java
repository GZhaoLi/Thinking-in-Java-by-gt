package com.gui.demo.thingInJava.Files.appendixIO;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Classname UsingRandomAccessFile
 * @Description TODO
 * @Date 2021/9/10 18:28
 * @Created by gt136
 */
public class UsingRandomAccessFile {
    static String file = "rtest.dat";

    /**
     * 打开一个文件，并以 double 值的形式显示了其中七个元素
     */
    public static void display() {
        try (
                //构造器第二个必选参数：我们可以指定让 RandomAccessFile 以“只读”（r）方式或“读写” （rw）方式打开文件
                RandomAccessFile rf = new RandomAccessFile(file, "r");
        ) {
            for (int i = 0; i < 7; i++) {
                System.out.println("Value " + i + ": " + rf.readDouble());
            }
            System.out.println(rf.readUTF());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //创建文件并修改它
        try (RandomAccessFile tf = new RandomAccessFile(file, "rw")) {
            for (int i = 0; i < 7; i++) {
                tf.writeDouble(i * 1.414);
            }
            tf.writeUTF("The end of the file");
            tf.close();
            display();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (RandomAccessFile rf = new RandomAccessFile(file, "rw")) {
            //double 都是8字节，所以用seek定位到第5个double值，所以传入的值为5*8
            rf.seek(5 * 8);
            rf.writeDouble(47.0001);
            rf.close();
            display();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
outputs:
Value 0: 0.0
Value 1: 1.414
Value 2: 2.828
Value 3: 4.242
Value 4: 5.656
Value 5: 7.069999999999999
Value 6: 8.484
The end of the file
Value 0: 0.0
Value 1: 1.414
Value 2: 2.828
Value 3: 4.242
Value 4: 5.656
Value 5: 47.0001
Value 6: 8.484
The end of the file
 */
