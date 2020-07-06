package com.chao.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        // 获取公平锁或者非公平锁，通过构造器传参
        ReentrantLock lock = new ReentrantLock(true);
        try {
            lock.lock();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
