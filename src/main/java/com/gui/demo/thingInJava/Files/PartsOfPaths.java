package com.gui.demo.thingInJava.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Classname PartsOfPaths
 * @Description  选取路径部分片段
 * @Date 2021/8/31 17:07
 * @Created by gt136
 */
public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("PartsOfPaths.java").toAbsolutePath();
        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
        }
        System.out.println("ends with '.java': " + p.endsWith(".java"));
        for (Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }
        System.out.println("Starts with " + p.getRoot() + " "+ p.startsWith(p.getRoot()));
        System.out.println();
    }
}
/*
outputs:
Windows 10
Users
gt136
Downloads
demo
PartsOfPaths.java
ends with '.java': false
Users: false : false
gt136: false : false
Downloads: false : false
demo: false : false
PartsOfPaths.java: false : true
Starts with C:\ true
 */