package com.multiplethread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Lock lockAhri = new ReentrantLock();
        Lock lockAnnie = new ReentrantLock();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                // 占有九尾妖狐
                boolean ahriLocked = false;
                boolean annieLocked = false;

                try {
                    ahriLocked = lockAhri.tryLock(10, TimeUnit.SECONDS);
                    if (ahriLocked) {
                        System.out.println("t1 已占有九尾妖狐");
                        // 停顿1000秒，另一个线程有足够的时间占有安妮
                        Thread.sleep(1000);
                        System.out.println("t1 试图在10秒内占有安妮");
                        try {
                            annieLocked = lockAnnie.tryLock(10, TimeUnit.SECONDS);
                            if (annieLocked) {
                                System.out.println("t1 成功占有安妮，开始啪啪啪");
                            } else {
                                System.out.println("t1 老是占用不了安妮，放弃");
                            }

                        } finally {
                            if (annieLocked) {
                                System.out.println("t1 释放安妮");
                                lockAnnie.unlock();
                            }
                        }

                    }
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } finally {
                    if (ahriLocked) {
                        System.out.println("t1 释放九尾狐");
                        lockAhri.unlock();
                    }
                }

            }
        };
        t1.start();

        Thread.sleep(100);

        Thread t2 = new Thread() {
            @Override
            public void run() {
                boolean annieLocked = false;
                boolean ahriLocked = false;

                try {
                    annieLocked = lockAnnie.tryLock(10, TimeUnit.SECONDS);

                    if (annieLocked) {

                        System.out.println("t2 已占有安妮");
                        // 停顿1000秒，另一个线程有足够的时间占有安妮
                        Thread.sleep(1000);
                        System.out.println("t2 试图在10秒内占有九尾妖狐");
                        try {
                            ahriLocked = lockAhri.tryLock(10, TimeUnit.SECONDS);
                            if (ahriLocked)
                                System.out.println("t2 成功占有九尾妖狐，开始啪啪啪");
                            else {
                                System.out.println("t2 老是占用不了九尾妖狐，放弃");
                            }
                        } finally {
                            if (ahriLocked) {
                                System.out.println("t2 释放九尾狐");
                                lockAhri.unlock();
                            }

                        }

                    }
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } finally {
                    if (annieLocked) {
                        System.out.println("t2 释放安妮");
                        lockAnnie.unlock();
                    }

                }
            }
        };
        t2.start();

    }
}
