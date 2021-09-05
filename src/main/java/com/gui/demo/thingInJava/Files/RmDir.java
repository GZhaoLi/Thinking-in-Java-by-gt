package com.gui.demo.thingInJava.Files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @Classname RmDir
 * @Description 目录树删除
 * @Date 2021/9/1 14:22
 * @Created by gt136
 */
public class RmDir {
    public static void rmdir(Path directory) throws IOException {
        Files.walkFileTree(directory,new SimpleFileVisitor<Path>(){
            //删除文件
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            //删除目录
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
