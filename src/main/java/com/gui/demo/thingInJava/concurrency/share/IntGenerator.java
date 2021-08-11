package com.gui.demo.thingInJava.concurrency.share;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Classname IntGenerator
 * @Description 消费者的检查
 * @Date 2021/7/22 15:43
 * @Created by gt136
 */
public abstract class IntGenerator {
    //    private volatile boolean canceled = false;旧模式定义
    private AtomicBoolean canceled = new AtomicBoolean();//新模式

    public abstract int next();

    public void setCanceled() {
        canceled.set(true);
    }

    public boolean isCanceled() {
        return canceled.get();
    }
}
