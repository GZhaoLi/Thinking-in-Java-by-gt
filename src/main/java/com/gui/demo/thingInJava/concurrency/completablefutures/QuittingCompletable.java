package com.gui.demo.thingInJava.concurrency.completablefutures;

import com.gui.demo.thingInJava.concurrency.Nap;
import com.gui.demo.thingInJava.concurrency.tasksExecutors.QuittableTask;
import com.gui.demo.thingInJava.concurrency.tasksExecutors.QuittingTasks;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Classname QuittingCompletable
 * @Description 使用 CompletableFuture 实现 QuitTask
 * @Date 2021/8/19 14:04
 * @Created by gt136
 */
public class QuittingCompletable {
    public static void main(String[] args) {
        List<QuittableTask> tasks = IntStream.range(0, QuittingTasks.COUNT)
                .mapToObj(QuittableTask::new)
                .collect(Collectors.toList());
        List<CompletableFuture<Void>> cfutures =
                tasks.stream()
                        /*
                         * completableFuture和ExecutorService实现多线程的区别在于前者可以更好的适应流式编程,而
                         * runAsync可以实现异步执行这些任务，也就是一个CompletableFuture对应一个任务。
                         */
                        .map(CompletableFuture::runAsync)//，
                        .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        cfutures.forEach(CompletableFuture::join);
    }
}
/*
output:
4 2 7 0 1 5 3 6 13 12 10 11 9 8 19 18 17 16 15 14 25 24 23 22 21 31 32 20 33 34 30 29 28 27 26 40 39 38 44 37 36 35 47 46
 45 43 42 41 53 52 51 50 49 48 59 58 57 56 55 54 65 64 63 62 61 60 71 70 69 68 67 66 77 76 75 74 73 72 83 82 81 80 79 78 89
 88 87 86 93 94 85 84 98 99 100 101 102 97 96 95 92 91 90 108 107 106 105 104 103 114 113 112 111 110 109 120 121 122 119
 118 117 116 115 128 127 126 125 124 123 134 133 132 131 130 140 129 141 139 138 137 136 135 147 146 145 144 143 142 149 148
 */
