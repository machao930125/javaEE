package com.chao;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程统计1-10000之间数字和
 *
 * @author chao
 */
public class MulThreadSum implements Runnable {
    int count;
    CountDownLatch latch;
    AtomicInteger integer;
    int[] arr;
    int index;

    public MulThreadSum(int count, CountDownLatch latch, AtomicInteger integer, int[] arr, int index) {
        this.count = count;
        this.latch = latch;
        this.integer = integer;
        this.arr = arr;
        this.index = index;
    }

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        int count = 10000;
        CountDownLatch latch = new CountDownLatch(5);
        int threadCount = 10;
        int[] arr = new int[threadCount];
        int sum = 0;

        for (int i = 0; i < threadCount; i++) {
            new Thread(new MulThreadSum(count, latch, integer, arr, i)).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < threadCount; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

    @Override
    public void run() {
        try {
            while (integer.get() < count) {
                int result = integer.incrementAndGet();
                if (result > count) {
                    continue;
                }
                arr[index] += result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }
}
