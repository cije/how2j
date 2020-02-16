package com.test;

import com.multiplethread.character.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * <h2>聚合操作</h2>
 * 管道源
 * <p>
 * 把Collection切换成管道源很简单，调用stream()就行了。
 * heros.stream()<p>
 * 但是数组却没有stream()方法，需要使用
 * Arrays.stream(hs)<p>
 * 或者
 * Stream.of(hs)
 */
public class TestAggregate {
    public static void main(String[] args) {
        Random random = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero" + i, random.nextInt(1000), random.nextInt(100)));
        }
        //管道源是集合
        //输出
        heros.stream().forEach(h -> System.out.println(h.toString()));
        System.out.println();
        //筛选
        heros.stream().filter(h -> h.hp > 100 && h.damage < 50).forEach(h -> System.out.println(h.toString()));
        System.out.println();

        Hero[] heroes = heros.toArray(new Hero[heros.size()]);
        //管道源是数组
        Stream.of(heroes).forEach(h -> System.out.println(h.name));
    }
}
