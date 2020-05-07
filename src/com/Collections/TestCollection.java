package com.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author c__e
 * @date 2020/4/21 16:38
 */
public class TestCollection {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("集合中的数据：");
        System.out.println(list);

        Collections.reverse(list);
        System.out.println("翻转后的数据：");
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println("混淆后的数据:");
        System.out.println(list);

        Collections.sort(list);
        System.out.println("对集合排序（默认升序）：");
        System.out.println(list);
        Collections.sort(list, (x1, x2) -> x2 - x1);
        System.out.println("降序排序：");
        System.out.println(list);

        Collections.swap(list, 0, 9);
        // 0 9为下标
        System.out.println("交换集合中两个数据的位置：");
        System.out.println(list);

        Collections.rotate(list, 2);
        System.out.println("将集合的数据像右滚动2个单位：");
        System.out.println(list);

        test();
    }

    static void test() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        int count = 0, n = 1000000;
        for (int i = 0; i < n; i++) {
            Collections.shuffle(list);
            if (list.get(0) == 3 && list.get(1) == 1 && list.get(2) == 4) {
                count++;
            }
        }
        System.out.printf("shuffle 1000,000 次，出现的次数为%d，", count);
        System.out.println("概率为：" + count * 100.0 / n + "%");
    }
}
