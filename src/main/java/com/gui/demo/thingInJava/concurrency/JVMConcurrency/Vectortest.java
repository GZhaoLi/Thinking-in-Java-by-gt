package com.gui.demo.thingInJava.concurrency.JVMConcurrency;

import java.util.Vector;

/**
 * @author chappyzhao
 * @Description
 * @create 2022-11-06 13:31
 */
public class Vectortest {
    private static final Vector<Integer> vector = new Vector<>();

    public static void main(String[] args){
        while(true){
            for(int i = 0;i<10;i++){
                vector.add(i);
            }
            Thread removeThread = new Thread(new Runnable(){
                @Override
                public void run(){
                    synchronized(vector){
                        for(int i=0; i< vector.size();i++){
                            vector.remove(i);
                        }
                    }
                }
            });

            Thread printThread = new Thread(new Runnable(){
                @Override
                public void run(){
                    synchronized(vector){
                        for(int i= 0;i<vector.size();i++){
                            System.out.println(vector.get(i));
                        }
                    }
                }
            });


            removeThread.start();
            printThread.start();

            while(Thread.activeCount()>20);
        }


    }
}
