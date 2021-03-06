package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    static Connection connection = null;
    static Statement s = null;
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/hero?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
    final static String USER = "root";
    final static String PASSWORD = "123456";

    public static void main(String[] args) {
        getConnect();
        String sql = "delete from hero where id>100;";
        execute(sql);
        closeAll();
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

    public static void execute(String sql) {
        if (s != null) {
            try {
                s.execute(sql);
                System.out.println("执行语句成功");
            } catch (SQLException e) {
                System.out.println("执行语句失败");
                e.printStackTrace();
            }
        }
    }
}
