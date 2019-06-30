package com.chao.producerAndConsumer;

import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.Semaphore;

/**
 * @author machao
 */
@Data
public class Test6 implements Serializable {

    private int age;
    private String name;

    public static void main(String[] args) {
        final Semaphore notFull = new Semaphore(10,true);
        final Semaphore notEmpty = new Semaphore(0);
        try {
            notFull.release();
            for (int i = 0; i < 19; i++) {
                System.out.println(i);
                notFull.acquire();
                System.out.println(notFull.getQueueLength());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
