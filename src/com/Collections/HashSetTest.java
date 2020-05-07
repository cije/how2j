package com.Collections;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author c__e
 * @date 2020/4/20 9:51
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(1);
        System.out.println(hashSet);
        for (Iterator<Integer> i = hashSet.iterator(); i.hasNext(); ) {
            int t = (Integer) i.next();
            System.out.println(i);
        }
        for (Integer integer : hashSet) {
            System.out.println(integer);
        }
    }
}
