package com.io.bufferstream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用缓存流读取数据
 * 缓存字符输入流 BufferedReader 可以一次读取一行数据
 * 缓存流必须建立在一个存在的流的基础上
 */
public class TestStream {
    public static void main(String[] args) {
        File file = new File("t1\\t3\\test.txt");
        /*创建文件字符流 缓存流必须建立在一个存在的流的基础上*/
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                //一次读一行
                String line = bufferedReader.readLine();
                if (null == line) {
                    break;
                }
                System.out.println(line);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
