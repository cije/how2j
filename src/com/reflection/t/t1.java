package com.reflection.t;

import com.Hero;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Hero h = getHero();
        System.out.println(h);
    }

    public static Hero getHero() {
        File file = new File("t1/hero.config");
        try {
            Scanner sc = new Scanner(file);
            String className = sc.nextLine();
            Class pClass = Class.forName(className);
            Constructor c = pClass.getConstructor();
            Hero h = (Hero) c.newInstance();
            return h;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
