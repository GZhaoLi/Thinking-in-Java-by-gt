package com.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 933
 * class RecentCounter {
 *     Queue<Integer> queue;
 *
 *     public RecentCounter() {
 *         queue = new ArrayDeque<Integer>();
 *     }
 *
 *     public int ping(int t) {
 *         queue.offer(t);
 *         while (queue.peek() < t - 3000) {
 *             queue.poll();
 *         }
 *         return queue.size();
 *     }
 * }
 */
public class RecentCounter {

    private int count;
    private final Queue<Integer> queue;

    public RecentCounter() {
        count = 0;
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        int recentCounter = 0;
        queue.add(t);
        count = t - 3000;
        while (!queue.isEmpty()) {
            if (queue.peek() < count) {
                break;
            }
            queue.poll();
            recentCounter++;
        }
        return recentCounter;
    }
}

