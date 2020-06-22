package com.chao.agent;

public class HelloXunChe {
    public static void main(String[] args) throws InterruptedException {
        HelloXunChe helloXunChe = new HelloXunChe();
        helloXunChe.sayHi();
    }
    public void sayHi() throws InterruptedException {
        System.out.println("hi, xunche");
        sleep();
    }
    public void sleep() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 200));
    }
}