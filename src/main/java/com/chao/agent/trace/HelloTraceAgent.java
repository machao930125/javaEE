package com.chao.agent.trace;

public class HelloTraceAgent {
    public static void main(String[] args) throws InterruptedException {
        HelloTraceAgent helloTraceAgent = new HelloTraceAgent();
        while (true) {
            helloTraceAgent.sayHi("xunche");
            Thread.sleep(100);
        }
    }
    public String sayHi(String name) throws InterruptedException {
        sleep();
        String hi = "hi, " + name + ", " + System.currentTimeMillis();
        return hi;
    }
    public void sleep() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 200));
    }
}