package com.io.characterstream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件加密
 * 加密算法：
 * 数字：
 * 如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
 * 如果是9的数字，变成0
 * 字母字符：
 * 如果是非z字符，向右移动一个，比如d变成e, G变成H
 * 如果是z，z->a, Z-A。
 * 字符需要保留大小写
 * 非字母字符
 * 比如‘,&^ 保留不变，中文也保留不变
 */
public class EncodeFile {

    public static void main(String[] args) {
        File encodingFile = new File("t1\\t2\\test3.txt");
        File encodedFile = new File("t1\\t2\\test3_encodedFile.txt");
        encodeFile(encodingFile, encodedFile);
    }

    public static void encodeFile(File encodingFile, File encodedFile) {
        try (FileReader fileReader = new FileReader(encodingFile); FileWriter fileWriter = new FileWriter(encodedFile);) {
            //读取源文件
            char[] fileContent = new char[(int) encodingFile.length()];
            fileReader.read(fileContent);
            System.out.println("加密前的内容:");
            System.out.println(new String(fileContent));

            //加密
            encode(fileContent);
            System.out.println("加密后的内容:");
            System.out.println(new String(fileContent));
            fileWriter.write(fileContent); //写入目标文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encode(char[] fileContent) {
        char c;
        for (int i = 0; i < fileContent.length; i++) {
            c = fileContent[i];
            if (isLetterOrDigit(c)) {
                switch (c) {
                    case '9':
                        c = '0';
                        break;
                    case 'z':
                        c = 'a';
                        break;
                    case 'Z':
                        c = 'A';
                        break;
                    default:
                        c++;
                        break;
                }
            }
            fileContent[i] = c;
        }
    }

    private static boolean isLetterOrDigit(char c) {
        String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        return -1 != str.indexOf(c);
    }
}
