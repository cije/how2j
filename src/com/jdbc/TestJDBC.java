package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hero?characterEncoding=UTF-8", "root", "root");
            System.out.println("连接成功，获取连接对象： " + connection);
            Statement s = connection.createStatement();
            System.out.println("获取 Statement对象： " + s);
            String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
            s.execute(sql);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
