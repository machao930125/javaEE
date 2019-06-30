package com.chao.thread;

public class SynchronizedDemo implements Runnable {
    private static int count = 0;

    private static Object lock = new Object();
    private SynchronizedDemo(){}
    private static SynchronizedDemo demo = null;

    public static SynchronizedDemo getInstance(){
        if (demo == null){
            synchronized (lock){
                if (demo == null){
                    demo = new SynchronizedDemo();
                }
            }
        }
        return demo;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(getInstance());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + count);
    }

    @Override
    public void run() {
        this.count();
    }

    public void count(){
        synchronized (lock){
            for (int i = 0; i < 1000000; i++)
                count++;
        }
    }
}