package com.gui.demo.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Classname TestUDPServer
 * @Description TODO
 * @Date 2021/5/23 23:13
 * @Created by gt136
 */
public class TestUDPServer {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(5678);

        byte buf[] = new byte[1024];
        //DatagramPacket:数据报包裹，用来接收客户端传输过来的数据，接收过来后将数据存在buf中。
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        while (true) {
            ds.receive(dp);
            //ds是一个byte型，要转化为long
            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
            DataInputStream dis = new DataInputStream(bais);
//            System.out.println(new String(buf,0,dp.getLength()));
            System.out.println(dis.readLong());
        }
    }
}
