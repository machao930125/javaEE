package com.chao.coding;

import java.util.concurrent.atomic.AtomicInteger;

public class MulThreadABC {

    public static void main(String[] args) {
        AtomicInteger state = new AtomicInteger(0);
        int count = 10;
        new Thread(() -> {
            for (int i = 0; i < count; ) {
                while (state.get() % 3 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": A");
                    state.incrementAndGet();
                    i++;
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < count; ) {
                while (state.get() % 3 == 1) {
                    System.out.println(Thread.currentThread().getName() + ": B");
                    state.incrementAndGet();
                    i++;
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < count; ) {
                while (state.get() % 3 == 2) {
                    System.out.println(Thread.currentThread().getName() + ": C");
                    state.incrementAndGet();
                    i++;
                }
            }
        }, "C").start();
    }
}
