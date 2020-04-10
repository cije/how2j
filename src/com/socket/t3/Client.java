package com.socket.t3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        while (true) {
            try {
                Socket s = new Socket("127.0.0.1", 8888);

                OutputStream os = s.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                Scanner sc = new Scanner(System.in);
                String msg = sc.next();
                dos.writeUTF(msg);
                os.close();
                dos.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ServerSocket ss = new ServerSocket(8889);
                Socket s = ss.accept();

                InputStream is = s.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                String msg = dis.readUTF();
                System.out.println("收到服务端的消息：" + msg);
                is.close();
                dis.close();
                s.close();
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
