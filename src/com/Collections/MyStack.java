package com.Collections;

import java.util.LinkedList;

/**
 * @author c__e
 * @date 2020/4/10 16:15
 */
public class MyStack implements StackTest {
    static LinkedList<Hero> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    @Override
    public void push(Hero h) {
        stack.addLast(h);
    }

    @Override
    public Hero pull() {
        return stack.removeLast();
    }

    @Override
    public Hero peek() {
        return stack.getLast();
    }
}
