package com.multiplethread.atomic;

public class Demo {
    public static void main(String[] args) {
        HeroT hero = new HeroT("Timo", 120);
        Thread[] add = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(() -> {
                hero.recover();
            });
            t.start();
            add[i] = t;
        }
        Thread[] dec = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(() -> {
                hero.hurt();
            });
            t.start();
            dec[i] = t;
        }
        for (Thread thread : add) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread thread : dec) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(hero.hp);
    }
}
