package com.multiplethread.method;

import com.multiplethread.character.Hero;

/**
 * <strong>join 加入到当前线程中</srtong><br/>
 * 首先解释一下主线程的概念<br/>
 * 所有进程，至少会有一个线程即主线程，即main方法开始执行，就会有一个看不见的主线程存在。<br/>
 * 在42行执行t.join，即表明在主线程中加入该线程。<br/>
 * 主线程会等待该线程结束完毕， 才会往下运行。
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        Hero gareen = new Hero("盖伦", 616, 50);
        Hero teemo = new Hero("提莫", 300, 30);
        Hero bh = new Hero("赏金猎人", 500, 30);
        Hero leesin = new Hero("盲僧", 455, 80);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (!teemo.isDead() && !gareen.isDead()) {
                    teemo.attackHero(gareen);
                    gareen.attackHero(teemo);
                }
            }
        };
        t1.start();
        //代码执行到这里，一直是main线程在运行
        try {
            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };
        //会观察到盖伦把提莫杀掉后，才运行t2线程F
        t2.start();
    }
}
