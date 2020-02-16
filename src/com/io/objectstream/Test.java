package com.io.objectstream;

import java.io.*;

/**
 * 准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组
 * 然后把该数组序列化到一个文件heros.lol
 * 接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样
 */

public class Test {
    public static void main(String[] args) {
        //Hero数组
        Hero[] heros = new Hero[]{
                new Hero("0", 100), new Hero("1", 100),
                new Hero("2", 100), new Hero("3", 100),
                new Hero("4", 100), new Hero("5", 100),
                new Hero("6", 100), new Hero("7", 100),
                new Hero("8", 100), new Hero("9", 100)
        };
        File file = new File("t1/t3/heros.lol");
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                FileInputStream fip = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fip);
        ) {
            for (Hero hero : heros) {
                oos.writeObject(hero);
            }
            Hero[] hs = new Hero[10];
            for (Hero h : hs) {
                h = (Hero) ois.readObject();
                System.out.println(h.toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
