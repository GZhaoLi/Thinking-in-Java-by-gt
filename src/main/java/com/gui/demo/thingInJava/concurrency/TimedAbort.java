// onjava/TimedAbort.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Terminate a program after t seconds
package com.gui.demo.thingInJava.concurrency;
import java.util.concurrent.*;
/**
 *
 * @author gt
 * @date 2021/8/2 17:24
 * @return null
 */
public class TimedAbort {
  private volatile boolean restart = true;
  public TimedAbort(double t, String msg) {
    /*
     * public static CompletableFuture<Void> runAsync(Runnable runnable) {
        return asyncRunStage(asyncPool, runnable);}
    * CompletableFuture的runAsync中使用lambda 表达式创建一个Runnable，该表达式使用runAsync() 静态方法，它的结果会立即返回。
    * 因此，TimedAbort 不会持续保持任何打开的任务，如果一个任务占用了太长时间，它仍将终止该任务（所以 TimedAbort 被称为守护进程）。
    * TimedAbort 还允许你 使用restart() 方法重启任务，在某些有用的活动进行时保持打开状态
     */
    CompletableFuture.runAsync(() -> {
      try {
        while(restart) {
          restart = false;
          TimeUnit.MILLISECONDS
            .sleep((int)(1000 * t));
        }
      } catch(InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(msg);
      System.exit(0);
    });
  }
  public TimedAbort(double t) {
    this(t, "TimedAbort " + t);
  }
  public void restart() { restart = true; }
}
