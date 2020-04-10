package com.socket.t3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        while (true) {
            try {
                ServerSocket ss = new ServerSocket(8888);
                Socket s = ss.accept();
                InputStream is = s.getInputStream();
                // 把输入流封装在DataInputStream
                DataInputStream dis = new DataInputStream(is);
                // 使用readUTF读取字符串
                String msg = dis.readUTF();
                System.out.println("收到客户端消息：" + msg);

                dis.close();
                is.close();
                s.close();
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Socket send = new Socket("127.0.0.1", 8889);
                OutputStream os = send.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                Scanner sc = new Scanner(System.in);
                String msg = sc.next();
                dos.writeUTF(msg);
                os.close();
                dos.close();
                send.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
