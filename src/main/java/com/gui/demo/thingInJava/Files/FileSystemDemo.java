package com.gui.demo.thingInJava.Files;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @Classname FileSystemDemo
 * @Description 查找文件系统相关信息
 * @Date 2021/9/2 11:09
 * @Created by gt136
 */
public class FileSystemDemo {
    static void show(String id, Object o) {
        System.out.println(id + ": " + o);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        //Returns:the default file system
        FileSystem fsys = FileSystems.getDefault();
        System.out.println(fsys);
        //遍历文件系统中的磁盘
        for (FileStore fs : fsys.getFileStores()) {
            show("File Store", fs);
        }
        for (Path rd : fsys.getRootDirectories()) {
            show("root directory", rd);
        }
        //返回文件系统中分隔符的名称
        show("Separator", fsys.getSeparator());
        //返回文件系统的用户首要服务
        show("UserPrincipalLookupService", fsys.getUserPrincipalLookupService());
        show("isOpen", fsys.isOpen());
        show("isReadOnly", fsys.isReadOnly());
        show("FileSystemProvider", fsys.provider());
        show("File Attribute Views", fsys.supportedFileAttributeViews());
    }
}
/*
outputs:
Windows 10
File Store: Windows (C:)
File Store: software (D:)
File Store: files (E:)
root directory: C:\
root directory: D:\
root directory: E:\
Separator: \
UserPrincipalLookupService: sun.nio.fs.WindowsFileSystem$LookupService$1@3feba861
isOpen: true
isReadOnly: false
FileSystemProvider: sun.nio.fs.WindowsFileSystemProvider@5b480cf9
File Attribute Views: [owner, dos, acl, basic, user]
 */