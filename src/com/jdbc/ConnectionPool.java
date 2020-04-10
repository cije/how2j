package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义数据库连接池
 * 1. ConnectionPool() 构造方法约定了这个连接池一共有多少连接<br/>
 * 2. 在init() 初始化方法中，创建了size条连接。 注意，这里不能使用try-with-resource这种自动关闭连接的方式，因为连接恰恰需要保持不关闭状态，供后续循环使用<br/>
 * 3. getConnection， 判断是否为空，如果是空的就wait等待，否则就借用一条连接出去<br/>
 * 4. returnConnection， 在使用完毕后，归还这个连接到连接池，并且在归还完毕后，调用notifyAll，通知那些等待的线程，有新的连接可以借用了。<br/>
 */
public class ConnectionPool {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/hero?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final static String USER = "root";
    private final static String PASSWORD = "123456";

    List<Connection> cs = new ArrayList<>();
    int size;

    public ConnectionPool(int size) {
        this.size = size;
        init();
    }

    public void init() {
        try {
            Class.forName(DRIVER);
            for (int i = 0; i < size; i++) {
                Connection c = DriverManager.getConnection(URL, USER, PASSWORD);
                cs.add(c);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        while (cs.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return cs.remove(0);
    }

    public synchronized void returnConnection(Connection c) {
        cs.add(c);
        this.notifyAll();
    }
}
