package com.multiplethread.sisuo;

import java.io.ObjectInputStream;

/**
 * <strong>练习-死锁</strong><br/>
 * 3个同步对象a, b, c
 * 3个线程 t1,t2,t3
 * 故意设计场景，使这3个线程彼此死锁
 */
public class Test {
    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();
        final Object c = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (a) {
                    System.out.println("t1 已占有 a");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 试图占有 b");
                    System.out.println("t1 等待中");
                    synchronized (b) {
                        System.out.println("b");
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (b) {
                    System.out.println("t2 已占有 b");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 试图占有 c");
                    System.out.println("t2 等待中");
                    synchronized (c) {
                        System.out.println("c");
                    }
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                synchronized (c) {
                    System.out.println("t3 已占有 c");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t3 试图占有 a");
                    System.out.println("t3 等待中");
                    synchronized (a) {
                        System.out.println("a");
                    }
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}
