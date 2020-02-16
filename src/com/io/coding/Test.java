package com.io.coding;

import java.io.UnsupportedEncodingException;

/**
 * 以字符 中 为例，查看其在不同编码方式下的值是多少
 */
public class Test {
    public static void main(String[] args) {
        String str = "中";
        showCode(str);
    }

    private static void showCode(String str) {
        String[] encodes = {"BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32"};
        for (String encode : encodes) {
            showCode(str, encode);
        }
    }

    private static void showCode(String str, String encode) {
        try {
            System.out.printf("字符：\"%s\" 的编码方式 %s 下的十六进制值为 %n", str, encode);
            byte[] bs = str.getBytes(encode);
            for (byte b : bs) {
                int i = b & 0xff;
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException：%s编码方式无法解析字符%s\n", encode, str);
        }
    }
}
