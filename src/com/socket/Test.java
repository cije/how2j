package com.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * 练习-判断本网段有多少可用的ip地址
 */
public class Test {
    public static void main(String[] args) throws Exception {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        String testip = ip.substring(0, ip.lastIndexOf('.') + 1);
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 255; i++) {
            boolean flag = true;
            Process p = Runtime.getRuntime().exec("ping -n 1 " + testip + i);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("timed out")) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(testip + i);
            }
            System.out.println("已完成第" + i + "个ip测试");
        }
        System.out.println("如下Ip地址可以连接：");
        for (
                String s : list) {
            System.out.println(s);
        }
        System.out.println("总共有：" + list.size() + " 个地址");
    }
}
