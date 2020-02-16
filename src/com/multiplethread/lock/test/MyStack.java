package com.multiplethread.lock.test;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyStack<T> {

    LinkedList<T> values = new LinkedList<>();
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public synchronized void push(T t) {
        lock.lock();
        try {
            while (values.size() >= 200) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            values.addLast(t);
        } finally {
            lock.unlock();
        }
    }

    public synchronized T pull() {
        T t;
        lock.lock();
        try {
            while (values.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            t = values.removeLast();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public T peek() {
        return values.getLast();
    }
}