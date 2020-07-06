package com.chao.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadPrint26English {
    /**
     * 两个线程分别打印26个英文字母的元音（a,e,i,o,u）和辅音（其他），按照字母顺序输出
     */
    private static String lock = "lock";
    private static char aChar = 'a';
    private static List list = new ArrayList<>();

    public static void main(String[] args) {
        list = Arrays.asList('a', 'e', 'i', 'o', 'u');

        new Thread(() -> {
            while (aChar <= 'z') {
                synchronized (lock) {
                    if (list.contains(aChar)){
                        System.out.println("thread1======:    " + aChar);
                        char next = next(aChar);
                        aChar = next;
                    }
                }

            }
        }, "thread1").start();

        new Thread(() -> {
            while (aChar <= 'z') {
                synchronized (lock) {
                    if (!list.contains(aChar) && aChar <= 'z'){
                        System.out.println("thread2======:    " + aChar);
                        char next = next(aChar);
                        aChar = next;
                    }
                }
            }
        }, "thread2").start();
    }

    public static char next(char c) {
        return (char) (c + 1);
    }


}
