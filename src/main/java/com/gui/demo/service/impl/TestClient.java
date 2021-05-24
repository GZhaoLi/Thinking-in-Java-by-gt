package com.gui.demo.service.impl;

import java.io.IOException;
import java.net.Socket;

/**
 * @Classname TestClient
 * @Description TODO
 * @Date 2021/5/23 20:08
 * @Created by gt136
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        /**
         * Socket(String host, int port):这个比较常用
         */
        Socket s = new Socket("127.0.0.1",666);

    }
}
