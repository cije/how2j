package com.Collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


/**
 * <p>
 * HashMap和Hashtable都实现了Map接口，都是键值对保存数据的方式
 * <ul>
 *     <li>
 * 区别1：<br/>
 * HashMap可以存放 null<br/>
 * Hashtable不能存放null<br/>
 *     </li>
 *     <li>
 * 区别2：<br/>
 * HashMap不是线程安全的类<br/>
 * Hashtable是线程安全的类<br/>
 * </li>
 * </ul>
 * </p>
 *
 * @author c__e
 * @date 2020/4/21 17:17
 */
public class TestCollection2 {
    public static void main(String[] args) {
        //HashMap和Hashtable都实现了Map接口，都是键值对保存数据的方式

        HashMap<String, String> hashMap = new HashMap<String, String>();

        //HashMap可以用null作key,作value
        hashMap.put(null, "123");
        hashMap.put("123", null);

        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        //Hashtable不能用null作key，不能用null作value
//        hashtable.put(null, "123");
//        hashtable.put("123", null);

        test();
    }

    static void test() {
        HashMap<String, String> map = new HashMap<>();
        map.put("adc", "物理英雄");
        map.put("apc", "魔法英雄");
        map.put("t", "坦克");
        System.out.println("初始化的:");
        System.out.println(map);

        HashMap<String, String> tmap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            tmap.put(entry.getValue(), entry.getKey());
        }
        map.clear();
        map.putAll(tmap);

        System.out.println("反转key和value后的:");
        System.out.println(map);
    }
}
