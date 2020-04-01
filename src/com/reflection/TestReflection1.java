package com.reflection;

import com.Hero;

import java.lang.reflect.Constructor;

/**
 * 通过反射机制创建一个对象
 */
public class TestReflection1 {
    public static void main(String[] args) {
        //传统的使用new的方式创建对象
        Hero h1 = new Hero();
        h1.setName("teemo");
        System.out.println(h1);

        try {
            //使用反射方式创建对象
            String classname = "com.Hero";
            //类对象
            Class pClass = Class.forName(classname);
            //构造器
            Constructor c = pClass.getConstructor();
            Hero h2 = (Hero) c.newInstance();
            h2.setName("gareen");
            System.out.println(h2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
