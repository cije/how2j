package com.multiplethread.method;

/**
 * <strong>yield临时暂停</strong><br/>
 * 当前线程，临时暂停，使得其他线程可以有更多的机会占用CPU资源
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        Hero1 gareen = new Hero1("盖伦", 6160, 2);
        Hero1 teemo = new Hero1("提莫", 3000, 3);
        Hero1 bh = new Hero1("赏金猎人", 5000, 3);
        Hero1 leesin = new Hero1("盲僧", 4550, 8);

        Thread t1 = new Thread() {
            public void run() {

                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {
                    //临时暂停，使得t1可以占用CPU资源
                    Thread.yield();
                    bh.attackHero(leesin);
                }
            }
        };

        t1.start();
        t2.start();
    }
}
