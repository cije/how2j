package com.jdbc;

import java.sql.*;

/**
 * 练习：<br/>当插入一条数据之后，通过获取自增长id，得到这条数据的id，比如是55<br/>删除这条数据的前一条，54<br/>
 * 如果54不存在，则删除53，以此类推知道删除上一条数据
 */
public class TestJDBC6 {
    private static Connection connection = null;
    private static Statement s = null;
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/hero?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final static String USER = "root";
    private final static String PASSWORD = "123456";

    public static void main(String[] args) {
        getConnect();
        test();
        closeAll();
    }

    public static void test() {
        try {
            String insertSql = "insert into hero values(null,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "test");
            ps.setFloat(2, 1);
            ps.setInt(3, 2);
            ps.execute();

            int id = 0;
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println("刚插入的数据的id是:" + id);

            for (int i = id - 1; i > 0; i--) {
                String selectSql = "select * from hero where id=" + i;
                ResultSet r = s.executeQuery(selectSql);
                if (r.next()) {
                    System.out.println("id=" + i + " 的数据存在，删除该数据");
                    String deleteSql = "delete from hero where id=" + i;
                    s.execute(deleteSql);
                    break;
                }
            }
        } catch (
                SQLException e) {
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
