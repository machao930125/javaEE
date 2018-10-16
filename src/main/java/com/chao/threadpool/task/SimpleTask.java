package com.chao.threadpool.task;

/**
 * Created by Admin on 2018/10/16.
 */
public class SimpleTask implements Runnable{
	private int taskNum;

	public SimpleTask(int num) {
		this.taskNum = num;
	}

	@Override
	public void run() {
		System.out.println("正在执行task "+taskNum);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task "+taskNum+"执行完毕");
	}
}
