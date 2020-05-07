package com.Collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 设计一个ArrayList，使得这个ArrayList里，又可以放Hero，又可以放Item,但是除了这两种对象，其他的对象都不能放
 *
 * @author c__e
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<LOL> list = new ArrayList<>();
        list.add(new Hero("teemo"));
        list.add(new Item("无尽之刃"));
        for (LOL lol : list) {
            System.out.println(lol.toString());
        }
        ArrayList<Hero> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(new Hero("Hero" + i));
        }
        Iterator<Hero> it = arrayList.iterator();
        while (it.hasNext()) {
            Hero h = it.next();
            int id = Integer.parseInt(h.name.substring(4));
            if (id % 8 == 0) {
                it.remove();
                System.out.println(h);
            }
        }
        System.out.println("现在集合中的元素个数：" + arrayList.size());
    }
}
