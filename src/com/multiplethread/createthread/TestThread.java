package com.multiplethread.createthread;

import com.multiplethread.character.Hero;

/**
 * 多线程即在同一时间，可以做多件事情。
 * <p>
 * <strong>创建多线程</strong>有3种方式，分别是<br/>
 * <ul>
 *     <li>继承线程类</li>
 *     <li>实现Runnable接口</li>
 *     <li>匿名类</li>
 * </ul>
 */
public class TestThread {
    static Hero gareen = new Hero("盖伦", 616, 50);
    static Hero teemo = new Hero("提莫", 300, 30);
    static Hero bh = new Hero("赏金猎人", 500, 30);
    static Hero leesin = new Hero("盲僧", 455, 80);

    public static void main(String[] args) {

    }

    /**
     * 此处代码演示的是不使用多线程的情况：
     * 只有在盖伦杀掉提莫后，赏金猎人才开始杀盲僧
     */
    static void attack() {
        //盖伦攻击提莫
        while (!teemo.isDead()) {
            gareen.attackHero(teemo);
        }
        // 赏金猎人攻击盲僧
        while (!leesin.isDead()) {
            bh.attackHero(leesin);
        }
    }

    /**
     * <h2>创建多线程-继承线程类</h2>
     * <p>使用多线程，就可以做到盖伦在攻击提莫的同时，赏金猎人也在攻击盲僧
     * 设计一个类KillThread 继承Thread，并且重写run方法<br/>
     * 启动线程办法： 实例化一个KillThread对象，并且调用其start方法
     * 就可以观察到 赏金猎人攻击盲僧的同时，盖伦也在攻击提莫</p>
     */
    static void threadTest() {
        // 继承线程类
        KillThread killThread1 = new KillThread(gareen, teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh, leesin);
        killThread2.start();
    }

    /**
     * <h2>创建多线程-实现Runnable接口</h2>
     * <p>创建类Battle，实现Runnable接口
     * 启动的时候，首先创建一个Battle对象，然后再根据该battle对象创建一个线程对象，并启动
     * <p>
     * Battle battle1 = new Battle(gareen,teemo);<br/>
     * new Thread(battle1).start();
     * <p>
     * battle1 对象实现了Runnable接口，所以有run方法，但是直接调用run方法，并不会启动一个新的线程。
     * 必须，借助一个线程对象的start()方法，才会启动一个新的线程。
     * 所以，在创建Thread对象的时候，把battle1作为构造方法的参数传递进去，这个线程启动的时候，就会去执行battle1.run()方法了。s</p>
     */
    static void threadTest1() {
        // 实现Runnable接口
        Battle battle1 = new Battle(gareen, teemo);
        new Thread(battle1).start();
        Battle battle2 = new Battle(bh, leesin);
        new Thread(battle2).start();
    }

    /**
     * <h2>创建多线程-匿名类</h2>
     * <p>使用匿名类，继承Thread,重写run方法，直接在run方法中写业务代码<br/>
     * 匿名类的一个好处是可以很方便的访问外部的局部变量。<p/>
     */
    static void threadTest2() {
        // 匿名类
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };
        t1.start();
        t2.start();
    }
}
