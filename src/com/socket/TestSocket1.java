package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * 使用Java执行Ping命令
 */
public class TestSocket1 {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("ping " + "192.168.137.1");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() != 0) {
                sb.append(line + "\r\n");
            }
        }
        System.out.println("本次指令返回的消息是：\n" + sb.toString());
    }
}
