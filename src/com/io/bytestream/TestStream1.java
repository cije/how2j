package com.io.bytestream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 创建文件并写入
 */
public class TestStream1 {
    public static void main(String[] args) {
        try {
            File file = new File("t1\\t2\\1.txt");
            //文件目录不存在 自动创建
            File dir = file.getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }

            byte[] bytes = new byte[]{24, 12, 13};
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
            System.out.println("Success!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
