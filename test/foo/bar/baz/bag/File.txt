package com.gui.demo.thingInJava.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname Directories
 * @Description
 * @Date 2021/9/1 15:43
 * @Created by gt136
 */
public class Directories {
    //Path.get() 会返回 FileSystems.getDefault().getPath(first, more);
    static Path test = Paths.get("test");
    //FileSystems.getDefault()会返回抽象默认的文件系统
    static String sep = FileSystems.getDefault().getSeparator();
    //
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        //将容器中的 元素按照distance重新在容器中放置
        Collections.rotate(parts, 1);
        //join 方法将sep字符插入到容器的中间（不包括开头和结尾）
        return Paths.get("test", String.join(sep, parts));
    }

    //删除或者创建新的路径
    static void refreshTestDir() throws IOException {
        if (Files.exists(test)) {
            //
            RmDir.rmdir(test);
        }
        if (!Files.exists(test)) {
            //
            Files.createDirectory(test);
        }
    }

    static void populateTestDir() throws IOException {
        for (int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();
            if (!Files.exists(variant)) {
                Files.createDirectories(variant);
                //将资源文件内容复制到第二个目标文件中去
                Files.copy(Paths.get("src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\Directories.java"), variant.resolve("File.txt"));
                Files.createTempFile(variant, null, null);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        refreshTestDir();

        Files.createFile(test.resolve("Hello.txt"));
        Path variant = makeVariant();
        try {
            Files.createDirectory(variant);
        } catch (IOException e) {
            System.out.println("Nope, that doesn't work.");
        }

        populateTestDir();

        Path tempdir = Files.createTempDirectory(test, "DIR_");
        Files.createTempFile(tempdir, "pre", ".non");

        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("**********************");
        Files.walk(test).forEach(System.out::println);
    }
}
/*
outputs:
Nope, that doesn't work.
test\bag
test\bar
test\baz
test\DIR_1992295150508866935
test\foo
test\Hello.txt
**********************
test
test\bag
test\bag\foo
test\bag\foo\bar
test\bag\foo\bar\baz
test\bag\foo\bar\baz\3481383038818368384.tmp
test\bag\foo\bar\baz\File.txt
test\bar
test\bar\baz
test\bar\baz\bag
test\bar\baz\bag\foo
test\bar\baz\bag\foo\8713177723820086212.tmp
test\bar\baz\bag\foo\File.txt
test\baz
test\baz\bag
test\baz\bag\foo
test\baz\bag\foo\bar
test\baz\bag\foo\bar\5063471877667292040.tmp
test\baz\bag\foo\bar\File.txt
test\DIR_1992295150508866935
test\DIR_1992295150508866935\pre6897899870957080456.non
test\foo
test\foo\bar
test\foo\bar\baz
test\foo\bar\baz\bag
test\foo\bar\baz\bag\2502025422016235731.tmp
test\foo\bar\baz\bag\File.txt
test\Hello.txt
 */