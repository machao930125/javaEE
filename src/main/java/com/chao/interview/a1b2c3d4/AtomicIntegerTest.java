package com.chao.interview.a1b2c3d4;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    static AtomicInteger integer = new AtomicInteger(1);

    public static void main(String[] args) {
        char[] aI = "123456789".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(()->{
            for (char c : aI) {
                while (integer.get() != 1){}
                System.out.println(c);
                integer.set(2);
            }
        },"t1").start();

        new Thread(()->{
            for (char c : aC) {
                while (integer.get() != 2){}
                System.out.println(c);
                integer.set(1);
            }
        },"t2").start();

    }
}
