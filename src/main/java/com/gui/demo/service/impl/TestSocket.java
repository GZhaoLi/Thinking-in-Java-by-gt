package com.gui.demo.service.impl;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Classname TestSocket
 * @Description TODO
 * @Date 2021/5/23 20:07
 * @Created by gt136
 */
public class TestSocket {
    public static void main(String[] args) throws IOException {
        /**
         * 这个是服务器socket，对应的是客户socket。一般要写socket一般两个一起写
         */
        ServerSocket ss = new ServerSocket(666);

        /**
         * 此时的accept就是接收客户端socket的请求连接，有一个socket请求连接，服务器端就accept一次。
         * 但是accept()方法是阻塞式的，如果没有人连接这个端口，它就会一直等
         * readUTF()也是阻塞式的
         */
        Socket s;
        while (true) {
            s = ss.accept();
            //记着，这里与客户端对应着写，那边输出这边就输入
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());
            dis.close();
            s.close();
            System.out.println("A Client connect!");
        }


    }
}
