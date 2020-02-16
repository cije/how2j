package com.io.coding;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 用FileInputStream 字节流正确读取中文
 * 为了能够正确的读取中文内容
 * 1. 必须了解文本是以哪种编码方式保存字符的
 * 2. 使用字节流读取了文本后，再使用对应的编码方式去识别这些数字，得到正确的字符
 * 如 本例，一个文件中的内容是字符 中 ，编码方式是 GBK ，那么读出来的数据一定是D6D0。
 * 再使用GBK编码方式识别D6D0，就能正确的得到字符中
 * <p>
 * 注： 在GBK的棋盘上找到的中字后，JVM会自动找到中在UNICODE这个棋盘上对应的数字，并且以UNICODE上的数字保存在内存中。
 */
public class TestStream {
    public static void main(String[] args) {
        //GBK编码文本文件
        File file = new File("t1\\t2\\zhong_GBK.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] all = new byte[(int) file.length()];
            fileInputStream.read(all);
            System.out.println("文件读出来的数据是：");
            for (byte b : all) {
                //只取16进制的后两位
                int i = b & 0x000000ff;
                System.out.println(Integer.toHexString(i));
            }
            System.out.println("把这个数字放到GBK的棋盘上去：");
            String str = new String(all, "GBK");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
