package com.chao.datastructure.queue;

/**
 *
 * @author Admin
 * @date 2018/10/23
 */
public interface queue<E> {
	/**
	 * 进入队列
	 * @param e
	 */
	void push(E e);

	/**
	 * 出队列
	 * @return
	 */
	E pop();

	/**
	 * 统计队列数据量
	 * @return
	 */
	int count();

	/**
	 * 展示队列信息
	 */
	void display();


}
