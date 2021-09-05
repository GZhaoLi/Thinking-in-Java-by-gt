package com.gui.demo.thingInJava.Files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Classname PathInfo
 * @Description Files 的使用，Paths和Path的区别
 * @Date 2021/8/30 11:00
 * @Created by gt136
 */
public class PathInfo {
    static void show(String id, Object path) {
        System.out.println(id + ": " + path);
    }
    static void info(Path path) {
        show("toString", path);
        show("Exists", Files.exists(path));
        show("RegularFile", Files.isRegularFile(path));
        show("Directory", Files.isDirectory(path));
        show("Absolute", path.isAbsolute());
        show("FileName", path.getFileName());
        show("Parent", path.getParent());
        show("Root", path.getRoot());
        System.out.println("*****************************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("C:", "path", "to", "nowhere", "NoFile.txt"));
        Path p = Paths.get("src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\PathInfo.java");
//        Path p = Paths.get("C:","Users\\gt136\\Downloads\\demo\\src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\PathInfo.java");
        info(p);
        Path ap = p.toAbsolutePath();
        info(ap);
        info(ap.getParent());

        try {
            info(p.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
        URI uri = p.toUri();
        System.out.println("URI: " + uri);
        Path puri = Paths.get(uri);
        System.out.println(Files.exists(puri));
        File f = ap.toFile();
    }
}
/*
outputs:
Windows 10
toString: C:\path\to\nowhere\NoFile.txt
Exists: true
RegularFile: true
Directory: false
Absolute: true
FileName: NoFile.txt
Parent: C:\path\to\nowhere
Root: C:\
*****************************
toString: src\main\java\com\gui\demo\thingInJava\Files\PathInfo.java
Exists: true
RegularFile: true
Directory: false
Absolute: false
FileName: PathInfo.java
Parent: src\main\java\com\gui\demo\thingInJava\Files
Root: null
*****************************
toString: C:\Users\gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava\Files\PathInfo.java
Exists: true
RegularFile: true
Directory: false
Absolute: true
FileName: PathInfo.java
Parent: C:\Users\gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava\Files
Root: C:\
*****************************
toString: C:\Users\gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava\Files
Exists: true
RegularFile: false
Directory: true
Absolute: true
FileName: Files
Parent: C:\Users\gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava
Root: C:\
*****************************
toString: C:\Users\gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava\Files\PathInfo.java
Exists: true
RegularFile: true
Directory: false
Absolute: true
FileName: PathInfo.java
Parent: C:\Users\gt136\Downloads\demo\src\main\java\com\gui\demo\thingInJava\Files
Root: C:\
*****************************
URI: file:///C:/Users/gt136/Downloads/demo/src/main/java/com/gui/demo/thingInJava/Files/PathInfo.java
true
 */