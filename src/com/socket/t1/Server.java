package com.socket.t1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // 服务端打开端口8888
            ServerSocket ss = new ServerSocket(8888);
            // 在8888端口上监听，看是否有连接请求过来
            System.out.println("监听在端口号：8888");
            Socket s = ss.accept();
            System.out.println("有连接过来" + s);
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
