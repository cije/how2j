package com.multiplethread.method;

/**
 * <strong>Thread.sleep()当前线程暂停</strong><br/>
 * Thread.sleep(1000); 表示当前线程暂停1000毫秒 ，其他线程不受影响<br/>
 * 会抛出InterruptedException 中断异常，因为当前线程sleep的时候，有可能被停止，这时就会抛出 InterruptedException
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int seconds = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                int seconds = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了QQSpeed %d 秒%n", seconds++);
                }
            }
        };
        t2.start();
    }
}
