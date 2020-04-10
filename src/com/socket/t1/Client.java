package com.socket.t1;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // 连接到本机的8888端口
            Socket s = new Socket("127.0.0.1", 8888);
            System.out.println(s);
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
