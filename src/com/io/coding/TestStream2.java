package com.io.coding;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 用FileReader 字符流正确读取中文
 * FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
 * 而FileReader使用的编码方式是Charset.defaultCharset()的返回值
 * FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替，像这样：
 * <p>
 * new InputStreamReader(new FileInputStream(f),Charset.forName("GBK"));
 *
 * @author c__e
 */
public class TestStream2 {
    public static void main(String[] args) {
//        File file = new File("t1\\t2\\zhong_GBK.txt");
        File file = new File("t1\\1.txt");
        System.out.println("默认编码方式：" + Charset.defaultCharset());
        try (FileReader fileReader = new FileReader(file)) {
            char[] ch = new char[(int) file.length()];
            fileReader.read(ch);
            System.out.printf("FileReader 会使用默认的编码方式 %s，识别出来的字符是：%n", Charset.defaultCharset());
            System.out.println(new String(ch));
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        FileReader是不能手动设置编码设置的，为了使用其他的编码格式，只能使用InputStreamReader来代替
        并且使用   new InputStreamReader(new FileInputStream(f),Charset.forName("GBK"));
        */
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charset.forName("GBK"))) {
            char[] ch = new char[(int) file.length()];
            inputStreamReader.read(ch);
            System.out.printf("InputStreamReader 指定编码方式GBK，识别出来的字符是：%n");
            System.out.println(new String(ch));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
