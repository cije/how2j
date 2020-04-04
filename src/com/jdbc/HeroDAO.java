package com.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO implements DAO {
    private static Connection connection = null;
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/hero?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final static String USER = "root";
    private final static String PASSWORD = "123456";


    public HeroDAO() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hero getHeroByID(int id) {
        String sql = "select * from hero where id=" + id;
        Hero h = null;
        try (Connection connection = getConnection(); Statement s = connection.createStatement()) {
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                String name = rs.getString(2);
                Float hp = rs.getFloat(3);
                int damage = rs.getInt(4);
                h = new Hero(id, name, hp, damage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return h;
    }

    @Override
    public int add(Hero h) {
        String sql = "insert into hero values(null,?,?,?)";
        int id = 0;
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, h.getName());
            ps.setFloat(2, h.getHp());
            ps.setInt(3, h.getId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            h.setId(id);
            System.out.println("添加" + h.toString() + "成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("添加失败");
        }
        return id;
    }

    @Override
    public void delete(Hero h) {
        String sql = "delete from hero where id=" + h.getId();
        try (Connection connection = getConnection(); Statement s = connection.createStatement()) {
            Hero t = getHeroByID(h.getId());
            s.execute(sql);
            System.out.println("删除成功:" + t.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hero h) {
        String sql = "update hero set name=?,hp=?,damage=? where id=?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(4, h.getId());
            ps.setString(1, h.getName());
            ps.setFloat(2, h.getHp());
            ps.setInt(3, h.getDamage());
            ps.execute();
            System.out.println("更新完成");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Hero> getAllHeros() {
        List<Hero> list = new ArrayList<>();
        String sql = "select * from hero";
        return getHeroes(sql, list);
    }

    @Override
    public List<Hero> list(int start, int count) {
        String sql = "select * from hero limit " + start + "," + count;
        List<Hero> list = new ArrayList<>();
        return getHeroes(sql, list);
    }

    private List<Hero> getHeroes(String sql, List<Hero> list) {
        try (Connection connection = getConnection(); Statement s = connection.createStatement()) {
            ResultSet rs = s.executeQuery(sql);
            Hero t = null;
            while (rs.next()) {
                t = new Hero(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
