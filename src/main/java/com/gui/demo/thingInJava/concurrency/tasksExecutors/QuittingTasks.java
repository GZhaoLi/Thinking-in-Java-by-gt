package com.gui.demo.thingInJava.concurrency.tasksExecutors;

import com.gui.demo.thingInJava.concurrency.Nap;

import javax.print.attribute.standard.QueuedJobCount;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Classname QuittingTasks
 * @Description TODO
 * @Date 2021/8/19 11:18
 * @Created by gt136
 */
public class QuittingTasks {
    public static final int COUNT = 150;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<QuittableTask> tasks = IntStream.range(0, COUNT)
                .mapToObj(QuittableTask::new)
                .peek(qt -> exec.execute(qt))
                .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        exec.shutdown();
    }
}
/*
output:
71 42 39 35 21 24 30 18 38 50 33 46 41 36 40 52 53 65 76 68 16 77 84 58 63 43 12 47 114 99 98 79 91 100 87 101 95 113 90 104
83 74 82 93 78 96 75 66 54 55 88 92 59 89 67 85 115 62 70 105 80 72 73 81 69 60 61 56 57 49 44 64 45 48 37 25 109 28 111 17
108 29 32 107 110 103 15 102 106 112 7 22 97 0 86 2 5 9 94 6 8 3 10 4 11 23 14 27 1 20 34 19 26 13 31 51 139 117 134 127 125
129 131 124 135 120 132 146 136 138 133 137 143 140 142 144 141 145 147 148 149 118 121 126 116 130 128 119 123 122
 */