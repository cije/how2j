package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{2, 4, 5, 6, 8, 10};
        Arrays.sort(array, new NewCompartor());
        System.out.println(Arrays.toString(array));

        Integer[] array1 = new Integer[]{2, 4, 5, 6, 8, 10};
        Arrays.sort(array1, (Integer o1, Integer o2) -> o2 - o1);
        System.out.println(Arrays.toString(array1));

        Integer[] array2 = new Integer[]{2, 4, 5, 6, 8, 10};
        Arrays.sort(array2, (Integer o1, Integer o2) -> {
            return o2.compareTo(o1);
        });
//        Arrays.sort(array2, (Integer o1, Integer o2) -> {
//            if (o1 > o2) {
//                return -1;
//            } else if (o1 < o2) {
//                return 1;
//            } else {
//                return 0;
//            }
//        });
        System.out.println(Arrays.toString(array2));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(0);
        list.add(1);
        System.out.println(list);
        list.removeIf(e -> e == 1 || e == 0);
        System.out.println(list);

        for (Integer num : list) {
            System.out.println(num);
        }

        EnumDemo e = EnumDemo.WEDNESDAY;
        System.out.println(e.toString());
        System.out.println(e.ordinal());
    }
}