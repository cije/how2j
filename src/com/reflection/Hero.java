package com.reflection;

public class Hero {
    public String name;
    public float hp;
    public int damage;
    public int id;

    static String copyright;

    static {
        System.out.println("初始化 copyright");
        copyright = "版权由Riot Games公司所有";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero() {

    }

    public Hero(String name) {
        name = name;
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + "]";
    }

    public boolean isDead() {
        // TODO Auto-generated method stub
        return false;
    }

    public void attackHero(Hero h2) {
        System.out.println(this.name + " 正在攻击 " + h2.getName());
    }
}