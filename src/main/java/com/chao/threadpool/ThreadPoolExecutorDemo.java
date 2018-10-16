package com.chao.threadpool;

import com.chao.threadpool.task.SimpleTask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 演示ThreadPoolExecutor
 *
 * @author machao
 * @date 2018/10/16
 */
public class ThreadPoolExecutorDemo {
     public static void main(String[] args) {   
         ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
          
         for(int i=0;i<15;i++){
             SimpleTask myTask = new SimpleTask(i);
             executor.execute(myTask);
             System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
             executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
         }
         executor.shutdown();
     }
}