package com.multiplethread.createthread;

import com.multiplethread.character.Hero;

/**
 * <strong>实现Runnable接口</strong>
 */
public class Battle implements Runnable {
    private Hero h1;
    private Hero h2;

    public Battle(Hero h1, Hero h2) {
        // TODO 自动生成的构造函数存根
        this.h1 = h1;
        this.h2 = h2;
    }

    @Override
    public void run() {
        // TODO 自动生成的方法存根
        while (!h2.isDead()) {
            h1.attackHero(h2);
        }
    }

}
