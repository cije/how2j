package com.reflection;

import com.multiplethread.character.Hero;

/**
 * 
 * 获取类对象有3种方式 1. Class.forName 2. Hero.class 3. new Hero().getClass()
 * 无论什么途径获取类对象，都会导致静态属性被初始化，而且只会执行一次。 （除了直接使用 Class c =
 * Hero.class这种方式，这种方式不会导致静态属性被初始化
 */
public class TestReflection {
    public static void main(String[] args) {
	String className = "how2j.Hero";
	try {
	    Class<?> pclass1 = Class.forName(className);
	    Class<?> pclass2 = Hero.class;
	    Class<?> pclass3 = new Hero().getClass();
	    System.out.println(pclass1 == pclass2);
	    System.out.println(pclass1 == pclass3);
	} catch (ClassNotFoundException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	}
    }
}
