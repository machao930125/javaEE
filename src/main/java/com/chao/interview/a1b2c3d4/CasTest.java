package com.chao.interview.a1b2c3d4;

public class CasTest {
    enum ReadyToRun {T1,T2}
    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {
        char[] aI = "123456789".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();


        new Thread(() -> {
            for (char c : aI) {
                while(r != ReadyToRun.T1){}
                System.out.println(c);
                r = ReadyToRun.T2;
            }
        },"t1").start();

        new Thread(() -> {
            for (char c : aC) {
                while(r != ReadyToRun.T2){}
                System.out.println(c);
                r = ReadyToRun.T1;
            }
        },"t2").start();
    }

}
