package com.multiplethread.method.pojie;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String password = randomString(3);
        System.out.println("密码是:" + password);
        List<String> passwords = new ArrayList<>();

        new PasswordThread(password, passwords).start();
        new LogThread(passwords).start();

    }

    private static String randomString(int length) {
        StringBuilder pool = new StringBuilder();
        for (short i = '0'; i <= '9'; i++) {
            pool.append((char) i);
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool.append((char) i);
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool.append((char) i);
        }
        char[] cs = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }
}