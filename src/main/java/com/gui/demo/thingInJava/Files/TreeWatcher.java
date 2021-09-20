package com.gui.demo.thingInJava.Files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * @Classname TreeWatcher
 * @Description 给路径下的每一级文件夹都设置监听器，来监听事件
 * @Date 2021/9/3 18:26
 * @Created by gt136
 */
public class TreeWatcher {
    static void watchDir(Path dir) {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher, ENTRY_DELETE);
            //开启单线程池来运行多个并发线程
            Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    //检索并删除下一个监视键，如果尚不存在则等待。
                    WatchKey key = watcher.take();
                    for (WatchEvent evt : key.pollEvents()) {
                        System.out.println("evt.context(): " + evt.context() +
                                "\nevt.count(): " + evt.count() +
                                "\nevt.kind(): " + evt.kind());
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.walk(Paths.get("test"))
                .filter(Files::isDirectory)
                .forEach(TreeWatcher::watchDir);
        PathWatcher.delTxtFiles();
    }
}
/*
outputs:
deleting test\bag\foo\bar\baz\File.txt
evt.context(): File.txt
evt.count(): 1
evt.kind(): ENTRY_DELETE
deleting test\bar\baz\bag\foo\File.txt
 */