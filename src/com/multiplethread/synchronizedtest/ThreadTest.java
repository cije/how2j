package com.multiplethread.synchronizedtest;

import com.multiplethread.character.Hero;

/**
 * <strong>线程同步问题</strong><br/>
 * 分析同步问题产生的原因<br/>
 * <ol>
 *     <li>假设增加线程先进入，得到的hp是10000</li>
 *     <li>进行增加运算</li>
 *     <li>正在做增加运算的时候，还没有来得及修改hp的值，减少线程来了</li>
 *     <li>减少线程得到的hp的值也是10000</li>
 *     <li>减少线程进行减少运算</li>
 *     <li>增加线程运算结束，得到值10001，并把这个值赋予hp</li>
 *     <li>减少线程也运算结束，得到值9999，并把这个值赋予hp</li>
 * </ol>
 * hp，最后的值就是9999<br/>
 * 虽然经历了两个线程各自增减了一次，本来期望还是原值10000，但是却得到了一个9999<br/>
 * 这个时候的值9999是一个错误的值，在业务上又叫做<strong>脏数据</strong><br/>
 * <strong>解决思路</strong><br/>
 * 总体解决思路是： 在增加线程访问hp期间，其他线程不可以访问hp
 * <ol>
 *  <li>增加线程获取到hp的值，并进行运算</li>
 *  <li>在运算期间，减少线程试图来获取hp的值，但是不被允许</li>
 *  <li>增加线程运算结束，并成功修改hp的值为10001</li>
 *  <li>减少线程，在增加线程做完后，才能访问hp的值，即10001</li>
 *  <li>减少线程运算，并得到新的值10000</li>
 * </ol>
 */
public class ThreadTest {
    public static void main(String[] args) {
        final Hero garen = new Hero("geren", 10000, 10);
        System.out.println("garen的初始血量为：" + garen.hp);

        int n = 10000;
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];

        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    garen.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
        }
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    garen.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }
        for (Thread addThread : addThreads) {
            try {
                addThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread reduceThread : reduceThreads) {
            try {
                reduceThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(n + "个增加线程和" + n + "个减少线程结束后\ngaren的血量变为：" + garen.hp);
    }
}
