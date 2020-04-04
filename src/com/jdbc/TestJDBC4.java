package com.jdbc;

import java.sql.*;

/**
 * 向数据库中插入10000条数据，分别使用Statement和PreparedStatement，比较各自花的时间差异
 */
public class TestJDBC4 {
    static Connection connection = null;
    static Statement s = null;
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/hero?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    final static String USER = "root";
    final static String PASSWORD = "123456";

    public static void main(String[] args) {
        getConnect();
        long startTime1 = System.currentTimeMillis();
        sTest();
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用Statement的时间：" + (endTime1 - startTime1));

        long startTime2 = System.currentTimeMillis();
        psTest();
        long endTime2 = System.currentTimeMillis();
        System.out.println("使用PreparedStatement的时间：" + (endTime2 - startTime2));
        closeAll();
    }

    public static void sTest() {
        String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
        try {
            for (int i = 0; i < 10000; i++) {
                s.execute(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void psTest() {
        String sql = "insert into hero values(null,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < 10000; i++) {
                ps.setString(1, "timo");
                ps.setFloat(2, 313.0f);
                ps.setInt(3, 50);
                ps.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
