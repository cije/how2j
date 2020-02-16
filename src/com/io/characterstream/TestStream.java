package com.io.characterstream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Reader字符输入流
 * Writer字符输出流
 * 专门用于字符的形式读取和写入数据
 */
public class TestStream {
    public static void main(String[] args) {
        test2();
    }

    /**
     * FileReader 是Reader子类，以FileReader 为例进行文件读取
     */
    static void test1() {
        //准备文件t1\t2\test.txt其中内容是AB
        File file = new File("t1\\t2\\test.txt");
        //创建基于文件的Reader
        try (FileReader fileReader = new FileReader(file)) {
            //创建字符数组，其长度就是文件的长度
            char[] ch = new char[(int) file.length()];
            //以字符流的形式读取文件所有内容
            fileReader.read(ch);
            for (char c : ch) {
                //打印出来是A B
                System.out.println(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileWriter 是Writer的子类，以FileWriter 为例把字符串写入到文件
     */
    static void test2() {
        File file = new File("t1\\t2\\test2.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            String str = "我说今晚月光那么美，你说是的";
            char[] ch = str.toCharArray();
            // 以字符流的形式把数据写入到文件中
            fileWriter.write(ch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}