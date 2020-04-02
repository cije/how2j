package com.reflection;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 练习-调用方法
 */
public class TestReflection4 {
    public static void main(String[] args) {
        File file = new File("t1/hero1.config");
        try {
            Scanner sc = new Scanner(file);
            String className1 = sc.nextLine();
            String hero1Name = sc.nextLine();
            String className2 = sc.nextLine();
            String hero2Name = sc.nextLine();

            Class class1 = Class.forName(className1);
            Object h1 = class1.getConstructor().newInstance();
            Field hero1Field = class1.getField("name");
            hero1Field.set(h1, hero1Name);

            Class class2 = Class.forName(className2);
            Object h2 = class2.getConstructor().newInstance();
            Field hero2Field = class2.getField("name");
            hero2Field.set(h2, hero2Name);

            Method method = class1.getMethod("attackHero", Hero.class);
            method.invoke(h1, h2);
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
