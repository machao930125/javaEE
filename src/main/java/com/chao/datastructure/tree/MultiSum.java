package com.chao.datastructure.tree;

import java.util.concurrent.CountDownLatch;

public class MultiSum implements  Runnable{
	
	private int[] sum;
	private int index;
	private CountDownLatch countDownLatch;

	public MultiSum(int[] sum, int index,CountDownLatch countDownLatch) {
		this.sum = sum;
		this.index = index;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		try{
			for (int i = 0; i <= 100000; i++) {
				this.sum[index] += i;
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			countDownLatch.countDown();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int threads = 5;
		CountDownLatch countDownLatch = new CountDownLatch(threads);
		long sum = 0;
		int[] subSum = new int[threads];
		for (int i = 0; i < threads; i++) {
			subSum[i] = 0;
		}
		for (int i = 0; i < threads; i++) {
			new Thread(new MultiSum(subSum,i,countDownLatch)).start();
		}
		countDownLatch.await();
		for (int i = 0; i < threads; i++) {
			sum += subSum[i];
		}
		System.out.println("The sum is :" + sum);
	}
}
