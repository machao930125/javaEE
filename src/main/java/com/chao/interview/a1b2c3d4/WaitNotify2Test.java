package com.chao.interview.a1b2c3d4;

import java.util.concurrent.CountDownLatch;

public class WaitNotify2Test {

//    private static boolean t2Started = false;
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        final Object o = new Object();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o){
            /*    while (!t2Started){
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/

                for (char c : aI) {
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t1").start();

        new Thread(()->{
            synchronized (o){
                for (char c : aC) {
                    System.out.println(c);
                    latch.countDown();
//                    t2Started = true;
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t2").start();

    }
}
