package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FindStringFile {
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        search("../how2j", "static");
        long endTime = System.nanoTime();
        System.out.println("程序耗时：" + (endTime - startTime));
    }

    private static void search(String folder, String search) {
        File file = new File(folder);
        if (!file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            return;
        }
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                find(file1.getAbsolutePath(), search);
            }
            if (file1.isDirectory()) {
                threadPoolExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        search(file1.getAbsolutePath(), search);
                    }
                });
            }
        }
    }

    private static void find(String filePath, String search) {
        File file = new File(filePath);
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String tmp;
            while (null != (tmp = bufferedReader.readLine())) {
                if (tmp.contains(search)) {
                    System.out.println("找到子目标字符串" + search + "，在文件：" + file.getAbsolutePath());
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
