package com.chao.thread.multiThread;

/**
 * Created by Administrator on 2018/4/14.
 */
public class MusicAndGame {
    public static void main(String[] args) {
        System.out.println("------------开始-----------");
        new Thread(()->playGame()).start();

        System.out.println("------------结束-----------");
    }


    private static void playGame(){
        for (int i = 0; i < 50; i++) {
            System.out.println("玩游戏。。。" + i);

                try {
                    if (i == 10) {
                        new Thread(() -> listenMusic()).start();
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


        }
    }

    private static void listenMusic(){
        for (int i = 0; i < 50; i++) {
            System.out.println("听音乐。。。" + i);
        }
    }

}
