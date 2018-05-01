package com.chao.thread.multiThread;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/4/14.
 */
public class EatAppleThread {
    public static void main(String[] args) {
        Person person = new Person();


        new Thread(person,"will").start();
        new Thread(person,"machao").start();
        new Thread(person,"xinxin").start();
    }
}
class Person extends Thread{
    private int num = 50;

    private final Lock lock = new ReentrantLock();

    public Person() {
    }

    public Person(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
           eat();
        }
    }
     void eat(){
        lock.lock();
         try {
            if (num>0){
                System.out.println(Thread.currentThread().getName() + "吃了编号为：" + num + "的苹果！");

                Thread.sleep(1000);

                num --;
            }
         } catch (InterruptedException e) {
             e.printStackTrace();
         }finally {
             lock.unlock();
         }

    }
}
