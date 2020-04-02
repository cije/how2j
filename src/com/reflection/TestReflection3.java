package com.reflection;

import java.lang.reflect.Method;

/**
 * 通过反射机制，调用一个对象的方法
 */
public class TestReflection3 {
    public static void main(String[] args) {
        Hero h = new Hero();
        try {
            //获取这个名字叫做setName，参数类型是String的方法
            Method m = h.getClass().getMethod("setName", String.class);
            //对h对象调用这个方法
            m.invoke(h, "盖伦");
            //使用传统方法调用getName方法
            System.out.println(h.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
