package com.socket.t4;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8888);
            new SendThread(s).start();
            new RecieveThread(s).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
