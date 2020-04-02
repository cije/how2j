package com.jdbc;

import java.sql.*;

/**
 * executeQuery 执行SQL查询语句,并把结果集返回给ResultSet
 */
public class TestJDBC1 {
    static Connection connection = null;
    static Statement s = null;
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/hero?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
    final static String USER = "root";
    final static String PASSWORD = "123456";

    public static void main(String[] args) {
        getConnect();
        list(5, 5);
        closeAll();
    }

    public static void select() {
        String sql = "select *from hero";
        executeQuery(sql);
    }

    public static void executeQuery(String sql) {
        try {
            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            int id, damage;
            float hp;
            String name;
            while (rs.next()) {
                //可以使用字段名
                id = rs.getInt("id");
                //也可以使用字段的顺序（从1开始）
                name = rs.getString(2);
                hp = rs.getFloat("hp");
                damage = rs.getInt(4);
                System.out.println(id + "\t" + name + "\t" + hp + "\t" + damage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param start 开始页数
     * @param count 一页显示的总数
     */
    public static void list(int start, int count) {
        String sql = "select *from hero limit " + start + "," + count + ";";
        executeQuery(sql);
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

    /**
     * 增删改
     */
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
