package com.test;

import java.io.UnsupportedEncodingException;

/**
 * 数字对应的中文
 * 找出 E5 B1 8C 这3个十六进制对应UTF-8编码的汉字
 */
public class Test2 {
    public static void main(String[] args) {
        byte[] bytes = new byte[3];
        bytes[0] = (byte) 0xE5;
        bytes[1] = (byte) 0xB1;
        bytes[2] = (byte) 0x8C;
        try {
            System.out.println("E5 B1 8C 对应的字符是：" + new String(bytes, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
