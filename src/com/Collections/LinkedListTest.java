package com.Collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LinkedList
 *
 * @author c__e
 * @date 2020/4/10 15:59
 */
public class LinkedListTest {
    public static void main(String[] args) {
        test2();
    }

    /**
     * LinkedList还实现了双向链表结构Deque，可以很方便的在头尾插入删除数据
     */
    private static void test1() {
        // LinkedList是一个双向链表结构的list
        LinkedList<Hero> ll = new LinkedList<Hero>();

        // 所以可以很方便的在头部和尾部插入数据
        // 在最后插入新的英雄
        ll.addLast(new Hero("hero1"));
        ll.addLast(new Hero("hero2"));
        ll.addLast(new Hero("hero3"));
        System.out.println(ll);

        // 在最前面插入新英雄
        ll.addFirst(new Hero("heroX"));
        System.out.println(ll);

        // 查看最前面的英雄
        System.out.println(ll.getFirst());
        // 查看最后面的英雄
        System.out.println(ll.getLast());

        // 删除最前面的英雄
        System.out.println(ll.removeFirst());
        // 删除最后面的英雄
        System.out.println(ll.removeLast());
        System.out.println(ll);
    }

    /**
     * LinkedList还实现了Queue接口(队列)。
     */
    private static void test2() {
        Queue<Hero> q = new LinkedList<>();

        System.out.println("初始化队列：");
        q.offer(new Hero("Hero1"));
        q.offer(new Hero("Hero2"));
        q.offer(new Hero("Hero3"));
        q.offer(new Hero("Hero4"));
        System.out.println(q);
        System.out.println("把第一个元素取出来:");
        Hero h = q.poll();
        System.out.println(h);
        System.out.println("取出第一个元素之后的队列：");
        System.out.println(q);

        System.out.println("查看第一个元素，不取出来");
        h = q.peek();
        System.out.println(h);
        System.out.println(q);
    }
}
