// onjava/Nap.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package com.gui.demo.thingInJava.concurrency;
import java.util.concurrent.*;

public class Nap {
  public Nap(double t) { // Seconds,因为乘以1000，所以对应的是秒数
    try {
      TimeUnit.MILLISECONDS.sleep((int)(1000 * t));
    } catch(InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
  public Nap(double t, String msg) {
    this(t);
    System.out.println(msg);
  }
}
