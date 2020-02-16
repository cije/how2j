package com.multiplethread.method;

/**
 * 去除暂停
 */
public class Hero1 {
    public String name;
    public float hp;
    public int damage;

    public Hero1(String name, float hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public Hero1() {
    }

    public void attackHero(Hero1 h) {
        if (damage >= h.hp) {
            h.hp = 0;
        } else {
            h.hp -= damage;
        }
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead()) {
            System.out.println(h.name + "死了！");
        }
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }
}
