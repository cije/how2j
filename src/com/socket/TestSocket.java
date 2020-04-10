package com.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取本机的IP地址
 */
public class TestSocket {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.println("本机IP地址：" + ip);
    }
}
