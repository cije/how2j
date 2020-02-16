package com.multiplethread.method;

/**
 * <strong>setDaemon守护线程</strong><br/>
 * 守护线程的概念是： <strong>当一个进程里，所有的线程都是守护线程的时候，结束当前进程。</strong><br/>
 * 就好像一个公司有销售部，生产部这些和业务挂钩的部门。<br/>
 * 除此之外，还有后勤，行政等这些支持部门。<br/>
 * 如果一家公司销售部，生产部都解散了，那么只剩下后勤和行政，那么这家公司也可以解散了。<br/>
 * 守护线程就相当于那些支持部门，如果一个进程只剩下守护线程，那么进程就会自动结束。<br/>
 * 守护线程通常会被用来做日志，性能统计等工作。
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                int second = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了 %d 秒LOL\n", ++second);
                }
            }
        };
        //设置守护线程
        t.setDaemon(true);
        t.start();
    }
}
