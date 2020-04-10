package com.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * 事务练习 分页查询
 */
public class TestJDBC8 {
    private static Connection connection = null;
    private static Statement s = null;
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/hero?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final static String USER = "root";
    private final static String PASSWORD = "123456";

    public static void main(String[] args) {
        getConnect();
        try {
            String sql = "select * from hero limit 49,10";
            ResultSet rs = s.executeQuery(sql);
            int[] ids = new int[10];
            int i = 0;
            while (rs.next()) {
                ids[i++] = rs.getInt(1);
            }

            connection.setAutoCommit(false);
            for (int id : ids) {
                String dsql = "delete from hero where id=" + id;
                System.out.println("试图删除 id=" + id + " 的数据");
                s.execute(sql);
            }
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("是否要删除数据(Y/N)");
                String t = sc.nextLine();
                if (t.equals("Y")) {
                    connection.commit();
                    System.out.println("已删除");
                    break;
                } else if (t.equals("N")) {
                    break;
                }
            }
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
