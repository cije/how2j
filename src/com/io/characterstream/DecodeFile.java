package com.io.characterstream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件解密
 * 解密算法：
 * 数字：
 * 如果不是0的数字，在原来的基础上减1，比如6变成5, 4变成3
 * 如果是0的数字，变成9
 * 字母字符：
 * 如果是非a字符，向左移动一个，比如e变成d, H变成G
 * 如果是a，a->z, A-Z。
 * 字符需要保留大小写
 * 非字母字符：
 * 比如‘,&^ 保留不变，中文也保留不变
 *
 * @author lenovo
 */
public class DecodeFile {
    public static void main(String[] args) {
        File decodingFile = new File("t1\\t2\\test3_encodedFile.txt");
        File decodedFile = new File("t1\\t2\\test3_decodedFile.txt");
        decodeFile(decodingFile, decodedFile);
    }

    public static void decodeFile(File decodingFile, File decodedFile) {
        try (FileReader fileReader = new FileReader(decodingFile); FileWriter fileWriter = new FileWriter(decodedFile)) {
            //读取源文件
            char[] fileContent = new char[(int) decodingFile.length()];
            fileReader.read(fileContent);
            System.out.println("解密前的内容:");
            System.out.println(new String(fileContent));

            //加密
            decode(fileContent);
            System.out.println("解密后的内容:");
            System.out.println(new String(fileContent));
            //写入目标文件
            fileWriter.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decode(char[] fileContent) {
        char c;
        for (int i = 0; i < fileContent.length; i++) {
            c = fileContent[i];
            if (isLetterOrDigit(c)) {
                switch (c) {
                    case '0':
                        c = '9';
                        break;
                    case 'a':
                        c = 'z';
                        break;
                    case 'A':
                        c = 'Z';
                        break;
                    default:
                        c--;
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
