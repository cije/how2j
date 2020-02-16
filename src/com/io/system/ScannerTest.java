package com.io.system;

import java.util.Scanner;

/**
 * Scanner
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("第一个整数：" + a);
        int b = sc.nextInt();
        System.out.println("第二个整数：" + b);
        sc.close();
    }
}
