package com.chao.producerAndConsumer;


/**
 * 生产者和消费者，wait()和notify()的实现
 *
 * @author machao
 * @date 2017年6月22日
 */
public class Test1 {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";
    private static String LOCK1 = "lock1";

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                try {
//                    Thread.sleep(3000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                synchronized (LOCK) {
                    while (count.equals(FULL)) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (LOCK1) {
                    while (count == 0) {
                        try {
                            LOCK1.wait();
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK1.notifyAll();
                }
            }
        }
    }
}