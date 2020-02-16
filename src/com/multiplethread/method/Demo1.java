package com.multiplethread.method;

/**
 * <strong>练习-英雄充能</strong><br/>
 * 英雄有可以放一个技能叫做: 波动拳。<br/>
 * 每隔一秒钟，可以发一次，但是只能连续发3次。<br/>
 * 发完3次之后，需要充能5秒钟，充满，再继续发。
 */
public class Demo1 {
    /**
     * 继承Thread类
     */
    static class Test extends Thread {
        @Override
        public void run() {
            int mp = 300;
            while (mp >= 10) {
                for (int i = 1; i <= 3; i++) {
                    mp -= 10;
                    System.out.println("波动拳第" + i + "发 耗蓝：10MP 剩余蓝量：" + mp);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("开始5秒的CD");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.start();
    }
}
