package com.jdbc;

import java.sql.*;

/**
 * 使用事务<br/>
 * 在事务中的多个操作，要么都成功，要么都失败<br/>
 * 通过 c.setAutoCommit(false);关闭自动提交<br/>
 * 使用 c.commit();进行手动提交
 */
public class TestJDBC7 {
    static Connection connection = null;
    static Statement s = null;
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/hero?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
    final static String USER = "root";
    final static String PASSWORD = "123456";

    public static void main(String[] args) {
        getConnect();
        try {
            s = connection.createStatement();

            // 在事务的前提下
            // 在事务的多个操作，要么都成功，要么都失败
            connection.setAutoCommit(false);

            //加血的SQL
            String sql1 = "update hero set hp= hp+1 where id=99";
            s.execute(sql1);

            // 减血的SQL
            // 不小心写错成了 updata(而非update)
            String sql2 = "update hero set hp= hp-1 where id=99";
            s.execute(sql2);

            //手动提交
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}