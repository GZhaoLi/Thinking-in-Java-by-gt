package com.gui.demo.thingInJava.Files;

import java.io.IOException;
import java.nio.file.*;

/**
 * @Classname Find
 * @Description 文件查找
 * @Date 2021/9/6 9:36
 * @Created by gt136
 */
public class Find {
    public static void main(String[] args) throws IOException {
        Path test = Paths.get("test");
        //如果路径存在则删除，否则新建新的
        Directories.refreshTestDir();
        //创建路径和写入文件内容
        Directories.populateTestDir();
        //在test后面新增文件夹
        Files.createDirectory(test.resolve("dir.tmp"));

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.{tmp,txt}");
        Files.walk(test)
                .filter(matcher::matches)
                .forEach(System.out::println);
        System.out.println("*****************************");

        PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("glob:*.tmp");
        Files.walk(test)
                .map(Path::getFileName)//筛选出只有末尾名称的文件和目录
                .filter(matcher2::matches)
                .forEach(System.out::println);
        System.out.println("**********************************");

        Files.walk(test)
                .filter(Files::isRegularFile)//
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
    }
}
/*
outputs:
test\bag\foo\bar\baz\4092140275367986776.tmp
test\bag\foo\bar\baz\File.txt
test\bar\baz\bag\foo\8648666806475045915.tmp
test\bar\baz\bag\foo\File.txt
test\baz\bag\foo\bar\469752048322624680.tmp
test\baz\bag\foo\bar\File.txt
test\dir.tmp
test\foo\bar\baz\bag\8022215776105811097.tmp
test\foo\bar\baz\bag\File.txt
*****************************
4092140275367986776.tmp
8648666806475045915.tmp
469752048322624680.tmp
dir.tmp
8022215776105811097.tmp
**********************************
4092140275367986776.tmp
8648666806475045915.tmp
469752048322624680.tmp
8022215776105811097.tmp
 */
