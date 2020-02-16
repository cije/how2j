package com.io.datastream;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 练习-向文件中写入两个数字，然后把这两个数字分别读取出来
 */
public class Test {
    public static void main(String[] args) {
        solve2();
    }

    /**
     * 第一种方式：
     * 使用缓存流把两个数字以字符串的形式写到文件里，再用缓存流以字符串的形式读取出来，然后转换为两个数字。
     * 注：
     * 两个数字之间要有分隔符用于区分这两个数字。 比如数字是31和15，如果不使用分隔符，那么就是3115，读取出来就无法识别到底是哪两个数字。 使用分隔符31@15能解决这个问题。
     */
    private static void solve1() {
        File file = new File("t1\\t3\\test3.txt");
        //写入
        try (FileWriter fileWriter = new FileWriter(file); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print("31@15");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读出
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            StringTokenizer stk = new StringTokenizer(bufferedReader.readLine(), "@");
            System.out.println(Integer.parseInt(stk.nextToken()) + " " + Integer.parseInt(stk.nextToken()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 第二种方式：
     * 使用数据流DataOutputStream向文件连续写入两个数字，然后用DataInpuStream连续读取两个数字
     */
    private static void solve2() {
        File file = new File("t1\\t3\\test3.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file); DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            dataOutputStream.writeInt(31);
            dataOutputStream.writeInt(15);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fileInputStream = new FileInputStream(file); DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
            int a = dataInputStream.readInt();
            int b = dataInputStream.readInt();
            System.out.println(a + " " + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
