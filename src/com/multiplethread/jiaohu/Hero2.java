package com.multiplethread.jiaohu;

class Hero2 {
    public String name;
    public float hp;

    public int damage;

    public Hero2(String name, float hp) {
        this.name = name;
        this.hp = hp;
    }

    public synchronized void recover() {
        if (1000 == hp) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
    }

    public synchronized void hurt() {
        hp = hp - 1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了
        this.notify();
    }

    public void attackHero(Hero2 h) {
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead()) {
            System.out.println(h.name + "死了！");
        }
    }

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }

}