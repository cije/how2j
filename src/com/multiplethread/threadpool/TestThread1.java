package com.multiplethread.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <strong>使用Java自带线程池</strong><br/>
 * 线程池类ThreadPoolExecutor在包java.util.concurrent下<br/>
 * ThreadPoolExecutor threadPool= new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());<br/>
 * 第一个参数10 表示这个线程池初始化了10个线程在里面工作<br/>
 * 第二个参数15 表示如果10个线程不够用了，就会自动增加到最多15个线程<br/>
 * 第三个参数60 结合第四个参数TimeUnit.SECONDS，表示经过60秒，多出来的线程还没有接到活儿，就会回收，最后保持池子里就10个<br/>
 * 第四个参数TimeUnit.SECONDS 如上<br/>
 * 第五个参数 new LinkedBlockingQueue() 用来放任务的集合<br/>
 * execute方法用于添加新的任务
 */
public class TestThread1 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务2");
            }
        });
    }
}
