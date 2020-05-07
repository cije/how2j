package com.Collections;

public class Hero implements LOL {
    public String name;
    public int hp;

    public int damage;

    public Hero() {

    }

    public Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    // 增加一个初始化name的构造方法
    public Hero(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }

}