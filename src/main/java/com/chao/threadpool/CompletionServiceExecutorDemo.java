package com.chao.threadpool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 演示ExecutorCompletionService
 *
 * @author machao
 * @date 2018/10/16
 */
public class CompletionServiceExecutorDemo {
    /**
     * 执行次数
     */
    public static int count = 10;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // 同时运行多个任务，那个任务先返回数据，就先获取该数据
        CompletionService<String> completionService = new ExecutorCompletionService<String>(threadPool);
        for (int i = 1; i <= count; i++) {
            final int seq = i;
            completionService.submit(()->{
                int waitTime = new Random().nextInt(10);
                TimeUnit.SECONDS.sleep(waitTime);
                return "callable:"+seq+" 执行时间："+waitTime+"s";
            });
        }

        for (int i = 1; i <= count; i++) {
            try {
                Future<String> future = completionService.take();
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }
}
