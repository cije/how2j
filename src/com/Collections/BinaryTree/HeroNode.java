package com.Collections.BinaryTree;

import com.Collections.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author c__e
 * @date 2020/4/10 16:37
 */
public class HeroNode {
    public HeroNode leftNode;
    public HeroNode rightNode;
    public Hero value;

    public void add(List<Hero> list) {
        for (Hero hero : list) {
            add(hero);
        }
    }

    public void add(Hero h) {
        if (null == value) {
            value = h;
        } else {
            if (h.hp >= value.hp) {
                if (null == leftNode) {
                    leftNode = new HeroNode();
                }
                leftNode.add(h);
            } else {
                if (null == rightNode) {
                    rightNode = new HeroNode();
                }
                rightNode.add(h);
            }
        }
    }

    public List<Hero> values() {
        List<Hero> list = new ArrayList<>();
        if (null != leftNode) {
            list.addAll(leftNode.values());
        }
        list.add(value);
        if (null != rightNode) {
            list.addAll(rightNode.values());
        }
        return list;
    }

    public static void main(String[] args) {
        Random random = new Random();
        HeroNode heroNode = new HeroNode();
        List<Hero> slist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            slist.add(new Hero("Hero" + i, random.nextInt(1000)));
        }
        System.out.println("初始化10个Hero：");
        System.out.println(slist);

        heroNode.add(slist);
        List<Hero> list = heroNode.values();
        System.out.println("根据血量倒排序的Hero：");
        System.out.println(list);
    }
}
