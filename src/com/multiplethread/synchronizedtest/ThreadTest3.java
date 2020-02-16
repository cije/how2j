package com.multiplethread.synchronizedtest;

import com.multiplethread.character.Hero;

/**
 * <strong>使用hero对象作为同步对象</strong>
 * <ul>
 *     <li>用gareen作为synchronized</li>
 *     <li>在方法hurt中有synchronized(this)</li>
 *     <li>在方法前，加上修饰符synchronized</li>
 * </ul>
 */
public class ThreadTest3 {
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
                    ////使用gareen作为synchronized
                    synchronized (garen) {
                        garen.recover();
                    }
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
                    //使用gareen作为synchronized
                    synchronized (garen) {
                        garen.hurt();
                    }
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
