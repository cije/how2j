package com.io.datastream;

import java.io.*;

/**
 * 使用数据流的writeUTF()和readUTF() 可以进行数据的格式化顺序读写
 * <p>
 * 如本例，通过DataOutputStream 向文件顺序写出 布尔值，整数和字符串。 然后再通过DataInputStream 顺序读入这些数据。
 * <p>
 * 注： 要用DataInputStream 读取一个文件，这个文件必须是由DataOutputStream 写出的，否则会出现EOFException，因为DataOutputStream 在写出的时候会做一些特殊标记，只有DataInputStream 才能成功的读取。
 */
public class DateStreamTest {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void read() {
        File file = new File("t1\\t3\\test2.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            boolean flag = dataInputStream.readBoolean();
            int i = dataInputStream.readInt();
            String str = dataInputStream.readUTF();

            System.out.println("读取到布尔值：" + flag);
            System.out.println("读取到整数：" + i);
            System.out.println("读取到字符串：" + str);

            fileInputStream.close();
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write() {
        File file = new File("t1\\t3\\test2.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeInt(300);
            dataOutputStream.writeUTF("123 this is gareen");

            fileOutputStream.close();
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
