package com.gui.demo.thingInJava.concurrency;

import java.util.concurrent.Callable;

/**
 * @Classname FultureServer
 * @Description TODO
 * @Date 2021/7/15 17:14
 * @Created by gt136
 */
public class FultureServer<T> {
    public <T> FultureInter getFulture(Callable<T> callable){
        FultureTask<T> strinfFultureTask = new FultureTask<T>();
        new Thread(()->{
            try {
                T content = callable.call();
//                strinfFultureTask.setContent(content);
                strinfFultureTask.done(content);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        return strinfFultureTask;
    }
}
