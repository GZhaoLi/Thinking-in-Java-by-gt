package com.gui.demo.thingInJava.concurrency;

/**
 * @Classname FultureTask
 * @Description TODO
 * @Date 2021/7/15 17:13
 * @Created by gt136
 */
public class FultureTask<T> implements FultureInter<T> {
    private volatile boolean flag = false;
    private T content;
    @Override
    public T get() {
        synchronized (this){
            while(!flag){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return content;
    }

    public void done(T content){
        synchronized (this){
            flag = true;
            this.setContent(content);
            this.notifyAll();
        }
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
