package com.jdbc;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        HeroDAO heroDao = new HeroDAO();
        List<Hero> list = heroDao.list(0, 10);
        list.stream().forEach(hero -> System.out.println(hero.toString()));
    }
}
