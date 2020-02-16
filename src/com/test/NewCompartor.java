package com.test;

import java.util.Comparator;

public class NewCompartor implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}