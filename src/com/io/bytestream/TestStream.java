package com.io.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestStream {
    public static void main(String[] args) {
        fileOutputStreamTest();
    }

    static void fileInputStreamTest() {
        try {
            // 准备文件test.txt其中的内容是AB，对应的ASCII分别是65 66
            File file = new File("t1\\t2\\test.txt");
            // 创建基于文件的输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            // 创建字节数组，其长度就是文件的长度
            byte[] bytes = new byte[(int) file.length()];
            // 以字节流的形式读取文件所有内容
            fileInputStream.read(bytes);
            fileInputStream.close();
            for (byte b : bytes) {
                // 打印出来是65 66
                System.out.println(b);
            }
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    static void fileOutputStreamTest() {
        try {
            // 准备文件test1.txt其中的内容是空的
            File file = new File("t1\\t2\\test1.txt");
            // 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
            byte[] bytes = new byte[]{88, 89};
            // 创建基于文件的输出流
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // 把数据写入到输出流
            fileOutputStream.write(bytes);
            // 关闭输出流
            fileOutputStream.close();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
