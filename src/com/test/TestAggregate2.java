package com.test;

import com.multiplethread.character.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * <h2>结束操作</h2>
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;当进行结束操作后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。 结束操作不会返回Stream，但是会返回int、float、String、 Collection或者像forEach，什么都不返回,。
 * 结束操作才真正进行遍历行为，前面的中间操作也在这个时候，才真正的执行。</p>
 * 常见结束操作如下：<br/>
 * <ul>
 *    <li>forEach() 遍历每个元素</li>
 *      <li>toArray() 转换为数组</li>
 *      <li>min(Comparator<T>) 取最小的元素</li>
 *      <li>max(Comparator<T>) 取最大的元素</li>
 *      <li>count() 总数</li>
 *      <li>findFirst() 第一个元素
 * </ul>
 */
public class TestAggregate2 {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero" + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("遍历集合中的每个数据");
        heros.stream().forEach(h -> System.out.println(h));
        System.out.println("返回一个数组");
        Object[] hs = heros.stream().toArray();
        System.out.println(Arrays.toString(hs));
        System.out.println("返回伤害值最低的那个英雄");
        Hero minDamageHero = heros.stream().min((h1, h2) -> h1.getDamage() - h2.damage).get();
        System.out.println(minDamageHero);
        System.out.println("返回伤害值最高的那个英雄");
        Hero maxDamageHero = heros.stream().max((h1, h2) -> h1.getDamage() - h2.damage).get();
        System.out.println(maxDamageHero);
        System.out.println("流中数组的总数");
        long count = heros.stream().count();
        System.out.println(count);
        System.out.println("第一个英雄");
        Hero firstHero = heros.stream().findFirst().get();
        System.out.println(firstHero);
        System.out.println("HP第三高的英雄");
        //跳过头两个，然后findFist()就是第三大的数据
        Hero thirdHpHero = heros.stream().sorted((h1, h2) -> h2.hp > h1.hp ? 1 : -1).skip(2).findFirst().get();
        System.out.println(thirdHpHero);
    }
}
