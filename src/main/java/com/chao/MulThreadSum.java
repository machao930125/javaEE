package com.chao;

import java.util.concurrent.atomic.AtomicInteger;

public class MulThreadSum {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(10000);
        int threadCount = 5;
        int[] arr = new int[threadCount];
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (integer.get() < 10000) {
                    int i1 = integer.incrementAndGet();
                    if (i1 > 10000){
                        continue;
                    }
                    arr[i] += i1;
                }
            }).start();
        }
    }
}
