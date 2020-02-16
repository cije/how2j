package com.multiplethread.method;

/**
 * <strong>线程优先级</strong><br/>
 * 当线程处于竞争关系的时候，优先级高的线程会有更大的几率获得CPU资源
 * 为了演示该效果，要把暂停时间去掉，多条线程各自会尽力去占有CPU资源
 * 同时把英雄的血量增加100倍，攻击减低到1，才有足够的时间观察到优先级的演示
 * 如图可见，线程1的优先级是MAX_PRIORITY，所以它争取到了更多的CPU资源执行代码
 */
public class ThreadTest2 {
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
                    bh.attackHero(leesin);
                }
            }
        };

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        
        t1.start();
        t2.start();
    }
}
