package com.jdbc;

import java.sql.*;

/**
 * 获取自增长ID以及表的元数据
 */
public class TestJDBC5 {

    private static Connection connection = null;
    private static Statement s = null;
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/hero?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final static String USER = "root";
    private final static String PASSWORD = "123456";

    public static void main(String[] args) {
        getConnect();
        test2();
        closeAll();
    }

    /**
     * 获取自增长id
     */
    public static void test1() {
        String sql = "insert into hero values(null,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, "盖伦");
            ps.setFloat(2, 616);
            ps.setInt(3, 100);
            // 执行插入语句
            ps.execute();

            //在执行插入语句后，MySQL会为新插入的数据分配一个自增长id
            // JDBC通过getGeneratedKeys获取该id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取表的元数据:和数据库服务器相关的数据，比如数据库版本，有哪些表，表有哪些字段，字段类型是什么等等。
     */
    public static void test2() {
        try {
            // 查看数据库层面的元数据
            // 即数据库服务器版本，驱动版本，都有哪些数据库等等
            DatabaseMetaData dbmd = connection.getMetaData();

            // 获取数据库服务器产品名称
            System.out.println("数据库产品名称：\t" + dbmd.getDatabaseProductName());
            // 获取数据库服务器产品版本号
            System.out.println("数据库产品版本：\t" + dbmd.getDatabaseProductVersion());
            // 获取数据库服务器用作类别和表名之间的分割符
            System.out.println("数据库和表的分割符：\t" + dbmd.getCatalogSeparator());
            // 获取驱动版本
            System.out.println("驱动版本：\t" + dbmd.getDriverVersion());

            System.out.println("可用的数据库列表：");
            // 获取数据库名称
            ResultSet rs = dbmd.getCatalogs();

            while (rs.next()) {
                System.out.println("数据库名称:\t" + rs.getString(1));
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

