package com.io.file;

import java.io.File;

//如果文件大小大于150K就是要筛选的大文件
public class BigFileSearch {
    public static void bigFileSearch(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                bigFileSearch(f);
            }
        }
        if (file.isFile()) {
            double size = file.length() / 1024.0;
            if (size > 150) {
                System.out.println(file.getAbsolutePath() + "的大小是：" + size);
            }
        }
    }

    public static void main(String[] args) {
        File file=new File("E:\\DATA\\lenovo\\Desktop\\lq");
        bigFileSearch(file);
    }
}
