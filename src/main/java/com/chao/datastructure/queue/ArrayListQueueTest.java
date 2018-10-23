package com.chao.datastructure.queue;

/**
 *
 * @author Admin
 * @date 2018/10/23
 */
public class ArrayListQueueTest {

	public static void main(String[] args) {
		ArrayListQueue<Integer> queue = new ArrayListQueue<>();

		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);

		queue.display();

		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.count());
		queue.display();
	}
}
