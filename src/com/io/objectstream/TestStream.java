package com.io.objectstream;

import java.io.*;

/**
 * 创建一个Hero对象，设置其名称为 garen。
 * 把该对象序列化到一个文件 garen.lol。
 * 然后再通过序列化把该文件转换为一个Hero对象
 * <p>
 * 注：把一个对象序列化有一个前提是：这个对象的类，必须实现了Serializable接口
 */
public class TestStream {
    public static void main(String[] args) {
        //创建一个Hero garen
        //要把Hero对象直接保存到文件上，务必让Hero类实现Serializable接口
        Hero h = new Hero();
        h.name = "garen";
        h.hp = 6000;

        //准备一个文件用于保存该对象
        File file = new File("t1/t3/garen.lol");

        try (
                //创建对象输出流
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                //创建对象输入流
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            objectOutputStream.writeObject(h);
            Hero h2 = (Hero) objectInputStream.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
