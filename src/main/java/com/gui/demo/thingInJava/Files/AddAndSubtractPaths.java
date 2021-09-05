package com.gui.demo.thingInJava.Files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Classname AddAndSubtractPaths
 * @Description
 * @Date 2021/9/1 9:32
 * @Created by gt136
 */
public class AddAndSubtractPaths {

    static Path basePath = Paths.get("..", "..", "..").toAbsolutePath().normalize();

    static void show(int id, Path result) {
        if (result.isAbsolute()) {
            System.out.println("(" + id + ")r " + basePath.relativize(result));
        }else {
            System.out.println("(" + id + ")" + result);
        }
        try {
            System.out.println("RealPath: " + result.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(basePath);
        Path p = Paths.get("src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\AddAndSubtractPaths.java")
                .toAbsolutePath();
        show(1, p);

        Path convoluted = p.getParent().getParent()
                .resolve("strings").resolve("..").resolve(p.getParent().getFileName());
        show(2, convoluted);
        show(3, convoluted.normalize());

        Path p2 = Paths.get("..", "..");
        show(4, p2);
        show(5, p2.normalize());
        show(6, p2.toAbsolutePath().normalize());

        Path p3 = Paths.get(".").toAbsolutePath();
        Path p4 = p3.resolve(p2);
        show(7, p4);
        show(8, p4.normalize());

        Path p5 = Paths.get("").toAbsolutePath();
        show(9, p5);
        show(10, p5.resolveSibling("strings"));
        show(11, Paths.get("nonexistent"));
    }
}
/*
outputs:
Windows 10
C:\Users
(1)r gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava\Files\AddAndSubtractPaths.java
RealPath: C:\Users\gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava\Files\AddAndSubtractPaths.java
(2)r gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava\strings\..\Files
RealPath: C:\Users\gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava\Files
(3)r gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava\Files
RealPath: C:\Users\gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava\Files
(4)..\..
RealPath: C:\Users\gt136
(5)..\..
RealPath: C:\Users\gt136
(6)r gt136
RealPath: C:\Users\gt136
(7)r gt136\Downloads\demo\.\..\..
RealPath: C:\Users\gt136
(8)r gt136
RealPath: C:\Users\gt136
(9)r gt136\Downloads\demo
RealPath: C:\Users\gt136\Downloads\demo
(10)r gt136\Downloads\strings
java.nio.file.NoSuchFileException: C:\Users\gt136\Downloads\strings
(11)nonexistent
java.nio.file.NoSuchFileException: C:\Users\gt136\Downloads\demo\nonexistent
 */