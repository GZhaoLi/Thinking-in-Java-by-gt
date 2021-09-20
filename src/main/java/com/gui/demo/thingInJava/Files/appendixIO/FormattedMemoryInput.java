package com.gui.demo.thingInJava.Files.appendixIO;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Classname FormattedMemoryInput
 * @Description 以字节读取文件
 * @Date 2021/9/10 16:56
 * @Created by gt136
 */
public class FormattedMemoryInput {
    public static void main(String[] args) {
        //DataInputStream 必须接受一个 InputStream
        try (DataInputStream in = new DataInputStream(
                //ByteArrayInputStream 必须接受一个字节数组，所以调用了 String.getByte()
                new ByteArrayInputStream(
                BufferedInputFile.read("src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\appendixIO\\FormattedMemoryInput.java")
                        .getBytes(StandardCharsets.UTF_8)
        ))) {
            while (true) {
                System.out.write((char) in.readByte());
            }
        } catch (EOFException e) {
            //当读取完文件后，会通过这个异常告知文件已经读完，这里不选择打印异常，而是用一句话替代
            System.out.println("\nEnd of stream");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
outputs:
package com.gui.demo.thingInJava.Files.appendixIO;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

......
......

            throw new RuntimeException(e);
        }
    }
}
End of stream
 */