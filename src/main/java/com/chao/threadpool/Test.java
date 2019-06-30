package com.chao.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,

                new PriorityBlockingQueue<Runnable>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < 30; i++) {

            MyTask myTask = new MyTask(i);
            try {
                executor.execute(myTask);

            }catch (Exception e){
                e.printStackTrace();
            }


            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +

                    executor.getQueue().size() + "，已执行完的任务数目：" + executor.getCompletedTaskCount());

        }

        executor.shutdown();

    }

}


class MyTask implements Runnable , Comparable<MyTask> {

    private int taskNum;


    public MyTask(int num) {

        this.taskNum = num;

    }


    @Override

    public void run() {

        System.out.println("正在执行task " + taskNum);

        try {

            Thread.sleep(10000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        System.out.println("task " + taskNum + "执行完毕");

    }

    @Override
    public int compareTo(MyTask o) {
        return this.taskNum > o.taskNum ? 1 : (this.taskNum < o.taskNum ? -1 : 0);
    }
}