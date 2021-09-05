package com.gui.demo.thingInJava.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Classname PathAnalysis
 * @Description Files 工具类
 * @Date 2021/8/31 18:02
 * @Created by gt136
 */
public class PathAnalysis {
    static void say(String id, Object result) {
        System.out.print(id + ": ");
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\PathAnalysis.java").toAbsolutePath();
        say("Exists", Files.exists(p));
        say("Dirctory", Files.isDirectory(p));
        say("Executable", Files.isExecutable(p));
        say("Readable", Files.isReadable(p));
        say("RegularFile", Files.isRegularFile(p));
        say("Writeble", Files.isWritable(p));
        say("notExists", Files.notExists(p));
        try {
            say("Hidden", Files.isHidden(p));
            say("size", Files.size(p));
            say("FileStone", Files.getFileStore(p));
            say("LastModified: ", Files.getLastModifiedTime(p));
            say("Owner", Files.getOwner(p));
            say("ContentType",Files.probeContentType(p));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        say("SymbolicLink", Files.isSymbolicLink(p));
        if (Files.isSymbolicLink(p)) {
            try {
                say("SymbolicLink", Files.readSymbolicLink(p));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
            try {
                say("PosixFilePermissions", Files.getPosixFilePermissions(p));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
/*
outputs:
Windows 10
Exists: true
Dirctory: false
Executable: true
Readable: true
RegularFile: true
Writeble: true
notExists: false
Hidden: false
size: 2072
FileStone: Windows (C:)
LastModified: : 2021-08-31T10:17:46.047597Z
Owner: LAPTOP-BCBU1OB4\gt136 (User)
ContentType: text/plain
SymbolicLink: false
 */