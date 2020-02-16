package com.multiplethread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class HeroT {
    public String name;
    public AtomicInteger hp;
    public int damage;

    public HeroT() {
    }

    public HeroT(String name, int hp) {
        this.name = name;
        this.hp = new AtomicInteger(hp);
    }

    /**
     * 回血
     */
    public void recover() {
        hp.incrementAndGet();
    }

    /**
     * 掉血
     */
    public void hurt() {
        hp.decrementAndGet();
    }


    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                '}';
    }
}
