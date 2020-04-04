package com.jdbc;

import java.sql.*;

/**
 * 使用PreparedStatement 从1开始<br/>
 * <p>PreparedStatement的优点</p>
 * <ul>
 *     <li>PreparedStatement 使用参数设置，可读性好，不易犯错</li>
 *     <li>PreparedStatement有预编译机制，性能比Statement更快</li>
 *     <li>防止SQL注入式攻击</li>
 * </ul>
 */
public class TestJDBC3 {
    static Connection connection = null;
    static Statement s = null;
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/hero?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    final static String USER = "root";
    final static String PASSWORD = "123456";

    public static void main(String[] args) {
        getConnect();
        String sql = "insert into hero values(null,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            // Statement需要进行字符串拼接，可读性和维修性比较差
            String sql0 = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
            s.execute(sql0);

            // PreparedStatement 使用参数设置，可读性好，不易犯错
            // "insert into hero values(null,?,?,?)";
            // 设置参数
            ps.setString(1, "提莫");
            ps.setFloat(2, 313);
            ps.setInt(3, 50);
            // 执行
            ps.execute();
        } catch (
                SQLException e) {
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
