package com.io.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 拆分文件
 */
public class SpiltFile {
    public static void main(String[] args) {
        int eachSize = 100 * 1024; //100K
        File srcfile = new File("CentOS.exe");
        spilt(srcfile, eachSize);
    }

    private static void spilt(File srcfile, int eachSize) {
        float srcSize = srcfile.length(); //源文件大小
        if (0 == srcSize) {
            throw new RuntimeException("文件长度为0，不可拆分！");
        }
        byte[] fileContent = new byte[(int) srcSize];
        try (FileInputStream fileInputStream = new FileInputStream(srcfile);) {
            fileInputStream.read(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int filenumber; //拆分的文件数量
        if (0 == (srcSize % eachSize)) {
            filenumber = (int) srcSize / eachSize;
        } else {
            filenumber = (int) (srcSize / eachSize) + 1;
        }
        for (int i = 0; i < filenumber; i++) {
            String eachFileName = srcfile.getName() + "_" + i;
            File eachFile = new File(srcfile.getParent(), eachFileName);
            byte[] eachContent;

            if (i != filenumber - 1) {
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, eachSize * (i + 1));
            } else {
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, fileContent.length);
            }
            try (FileOutputStream fileOutputStream = new FileOutputStream(eachFile);) {
                fileOutputStream.write(eachContent);
                System.out.printf("输出子文件%s,其大小是 %d 字节%n", eachFile.getAbsoluteFile(), eachFile.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
