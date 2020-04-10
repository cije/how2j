package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 练习-判断本网段有多少可用的ip地址(多线程)
 */
public class Test_ {

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        String ipRange = ip.substring(0, ip.lastIndexOf('.') + 1);
        System.out.println("本机ip地址：" + ip);
        System.out.println("网段是: " + ipRange);

        final List<String> ips = Collections.synchronizedList(new ArrayList<>());
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        final AtomicInteger number = new AtomicInteger();
        for (int i = 1; i <= 255; i++) {
            String testip = ipRange + i;
            threadPool.execute(() -> {
                if (isReachable(testip)) {
                    // System.out.println("找到可连接的ip地址：" + testip);
                    ips.add(testip);
                }
                synchronized (number) {
                    System.out.println("已经完成:" + number.incrementAndGet() + " 个 ip 测试");
                }
            });

        }

        // 等待所有线程结束的时候，就关闭线程池
        threadPool.shutdown();
        //等待线程池关闭，但是最多等待1个小时
        if (threadPool.awaitTermination(1, TimeUnit.HOURS)) {
            System.out.println("如下ip地址可以连接");
            for (String theip : ips) {
                System.out.println(theip);
            }
            System.out.println("总共有:" + ips.size() + " 个地址");

        }
    }

    private static boolean isReachable(String ip) {
        try {
            Process p = Runtime.getRuntime().exec("ping -n 1 " + ip);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("TTL")) {
                    br.close();
                    return true;
                } else if (line.contains("timed out")) {
                    br.close();
                    return false;
                }
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}