package com.chao.coding;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ProductAndConsumer {
    AtomicInteger count = new AtomicInteger(0);
    int full = 10;
    ReentrantLock lock = new ReentrantLock();

    class Product implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; ) {
                lock.lock();
                try {
                    if (count.get() < full) {
                        int andGet = count.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() + ":生产数据:" + andGet);
                        i++;
                    }
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 200; ) {
                lock.lock();
                try{
                    if (count.get() > 0) {
                        int i1 = count.decrementAndGet();
                        System.out.println(Thread.currentThread().getName() + ":消费数据:" + i1);
                        i++;
                    }
                }catch (Exception e){}finally {
                    lock.unlock();
                }

            }
        }
    }


    public static void main(String[] args) {
        ProductAndConsumer productAndConsumer = new ProductAndConsumer();
        new Thread(productAndConsumer.new Product()).start();
        new Thread(productAndConsumer.new Product()).start();
        new Thread(productAndConsumer.new consumer()).start();
    }
}
