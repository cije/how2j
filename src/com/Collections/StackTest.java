package com.Collections;

/**
 * @author c__e
 * @date 2020/4/10 16:14
 */
public interface StackTest {
    /**
     * 把英雄推入到最后位置
     **/
    void push(Hero h);

    /**
     * 把最后一个英雄取出来
     **/
    Hero pull();

    /**
     * 查看最后一个英雄
     **/
    Hero peek();
}
