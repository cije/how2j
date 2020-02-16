package com.multiplethread.jiaohu;

import java.util.Collections;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        String st = generate();
        Stack<Character> stack = new Stack<>();
        Collections.synchronizedList(stack);
        Thread Producer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    while (200 == stack.size()) {
                        try {
                            stack.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    char tmp = st.charAt((int) (Math.random() * st.length()));
                    stack.push(tmp);
                    System.out.println("Produce 压入 " + tmp);
                    stack.notify();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread Customer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    while (stack.empty()) {
                        try {
                            stack.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    char tmp = stack.pop();
                    System.out.println("Customer 弹出 " + tmp);
                    stack.notify();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        Producer.start();
        Customer.start();
    }

    static String generate() {
        StringBuilder stb = new StringBuilder();
        for (short i = 'A'; i <= 'Z'; i++) {
            stb.append((char) i);
        }
        return stb.toString();
    }
}
