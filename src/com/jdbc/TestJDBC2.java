package com.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * SQL语句判断账号密码是否正确
 */
public class TestJDBC2 {
    static Connection connection = null;
    static Statement s = null;
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/hero?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
    final static String USER = "root";
    final static String PASSWORD = "123456";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        getConnect();
        if (judge(user, password)) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("用户名或密码错误");
        }
        closeAll();
    }

    public static boolean judge(String user, String password) {
        String sql = "select * from user where name='" + user + "' and password='" + password + "';";
        try {
            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void getConnect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("连接成功，获取连接对象： " + connection);
            s = connection.createStatement();
            System.out.println("获取 Statement对象： " + s);
        } catch (Exception e) {
            System.out.println("连接失败");
            e.printStackTrace();
        }
    }

    public static void closeAll() {
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
