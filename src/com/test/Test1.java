package com.test;

import java.util.Arrays;

/**
 * Arrays.copyOfRange()  左闭右开
 */
public class Test1 {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] array1 = Arrays.copyOfRange(array, 0, 2);    // [0,2) 左闭右开
        System.out.println(Arrays.toString(array1));

        for (int i = 0; i < 4; i++) {
            int[] tmp = Arrays.copyOfRange(array, 4 * i, 4 * (i + 1));
            System.out.println(Arrays.toString(tmp));
        }
    }
}
