package com.gui.demo.thingInJava.Files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * @Classname PathWatcher
 * @Description TODO
 * @Date 2021/9/2 11:26
 * @Created by gt136
 */
public class PathWatcher {
    static Path path = Paths.get("test");

    static void delTxtFiles() {
        try {
            Files.walk(path)
                    .filter(f->f.toString().endsWith(".txt"))//筛选出以.txt结尾的文件
                    .forEach(f->{
                        try {
                            System.out.println("deleting " + f);
                            Files.delete(f);//删除掉整个文件夹
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            //如果路径存在则删除，否则新建新的
            Directories.refreshTestDir();
            //创建路径和写入文件内容
            Directories.populateTestDir();

            Files.createFile(path.resolve("Hello.txt"));
            //获取到监听器
            WatchService watcher = FileSystems.getDefault().newWatchService();
            //将监听器注册到 Path 路径上；第二个参数是指监听什么事件，这里指删除事件
            path.register(watcher, ENTRY_DELETE);
            //
            Executors.newSingleThreadScheduledExecutor()
                    .schedule(PathWatcher::delTxtFiles,250, TimeUnit.MILLISECONDS);
            //检索并删除下一个监视键，如果尚不存在则等待。
            WatchKey key = watcher.take();
            for (WatchEvent evt : key.pollEvents()) {
                System.out.println("evt.context(): " + evt.context() +
                        "\nevt.count(): " + evt.count() +
                        "\nevt.kind(): " + evt.kind());
                System.exit(0);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
/*
outputs:
deleting test\bag\foo\bar\baz\File.txt
deleting test\bar\baz\bag\foo\File.txt
deleting test\baz\bag\foo\bar\File.txt
deleting test\foo\bar\baz\bag\File.txt
deleting test\Hello.txt
evt.context(): Hello.txt
evt.count(): 1
evt.kind(): ENTRY_DELETE
 */