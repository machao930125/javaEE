package com.chao.juc;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> local1 = new ThreadLocal<>();
        ThreadLocal<String> local2 = new ThreadLocal<>();
        ThreadLocal<String> local3 = new ThreadLocal<>();

        local1.set("1");
        local2.set("2");
        local3.set("3");

        Thread thread = Thread.currentThread();
//        local1 = null;
//        local2 = null;
//        local1 = null;
//        System.gc();
        Thread thread1 = Thread.currentThread();
        local1.remove();
        local2.remove();
        Thread thread2 = Thread.currentThread();
    }
}
