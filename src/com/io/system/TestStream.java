package com.io.system;

import java.io.IOException;
import java.io.InputStream;

/**
 * 控制台输出
 * <p>
 * InputStream is = System.in
 */
public class TestStream {
    public static void main(String[] args) {
        //控制台输入
        try (InputStream is = System.in) {
            while (true) {
                int i = is.read();
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
