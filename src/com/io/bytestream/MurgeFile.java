package com.io.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件合并
 */
public class MurgeFile {
    public static void main(String[] args) {
        murgeFile("t1", "CentOS.exe");
    }

    private static void murgeFile(String folder, String fileName) {
        try {
            File destfile = new File(folder, fileName); //合并的目标文件
            FileOutputStream fileOutputStream = new FileOutputStream(destfile);
            int index = 0;
            while (true) {
                File eachFile = new File(folder, fileName + "_" + index++);
                if (!eachFile.exists()) {
                    break;
                }
                //读取子文件内容
                FileInputStream fileInputStream = new FileInputStream(eachFile);
                byte[] eachContent = new byte[(int) eachFile.length()];
                fileInputStream.read(eachContent);
                fileInputStream.close();
                //写入
                fileOutputStream.write(eachContent);
                fileOutputStream.flush();
                System.out.printf("把子文件%s写出到目标文件中%n", eachFile);
            }
            System.out.printf("最后目标文件的大小: %d 字节", destfile.length());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
