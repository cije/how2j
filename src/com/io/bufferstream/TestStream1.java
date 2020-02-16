package com.io.bufferstream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用缓存流写入数据
 * PrintWriter 缓存字符输出流， 可以一次写出一行数据
 * 有的时候，需要立即把数据写入到硬盘，而不是等缓存满了才写出去。 这时候就需要用到flush
 */
public class TestStream1 {
    public static void main(String[] args) {
        File file = new File("t1\\t3\\test1.txt");
        try {
            //创建文件字符流
            FileWriter fileWriter = new FileWriter(file);
            //缓存流必须建立在一个存在的流的基础上
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Hello world!");
            //强制把缓存中的数据写入硬盘，无论缓存是否已满
            printWriter.flush();

            printWriter.println("LALALAND!");
            printWriter.println("天将降大任于斯人也!");
            fileWriter.close();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
