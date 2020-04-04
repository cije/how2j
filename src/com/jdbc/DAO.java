package com.jdbc;

import java.util.List;

public interface DAO {
    /**
     * 根据id返回一个Hero对象
     */
    Hero getHeroByID(int id);

    /**
     * 把一个Hero对象插入到数据库中
     */
    int add(Hero h);

    /**
     * 把这个Hero对象对应的数据删除掉
     */
    void delete(Hero h);

    /**
     * 更新这条Hero对象
     */
    void update(Hero h);

    /**
     * @return 所有数据的列表
     */
    List<Hero> getAllHeros();

    /**
     * 分页查询
     **/
    List<Hero> list(int start, int count);
}
