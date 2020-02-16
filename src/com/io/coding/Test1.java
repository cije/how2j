package com.io.coding;

import java.io.UnsupportedEncodingException;

/**
 * 找出 E5 B1 8C 这3个十六进制对应UTF-8编码的汉字
 */
public class Test1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = new byte[]{(byte) 0xE5, (byte) 0xB1, (byte) 0x8C};
        System.out.println(new String(bytes, "UTF-8"));
    }
}
