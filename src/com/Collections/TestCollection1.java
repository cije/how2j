package com.Collections;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 生成50个 0-9999之间的随机数，要求不能有重复的
 *
 * @author c__e
 * @date 2020/4/21 17:08
 */
public class TestCollection1 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Random r = new Random();
        while (set.size() < 10) {
            set.add(r.nextInt(10000));
        }
        System.out.println(set);
    }
}
