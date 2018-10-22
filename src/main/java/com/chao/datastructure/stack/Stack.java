package com.chao.datastructure.stack;

/**
 *
 * @author machao
 * @date 2018/10/22
 */
public interface Stack <E> {
	/**
	 * 入栈操作
	 *
	 * @param e
	 * @return
	 */
	int push(E e);

	/**
	 * 出栈操作
	 *
	 * @return
	 */
	E pop();

	/**
	 * 检查栈是否空
	 *
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 查看栈顶元素
	 *
	 * @return
	 */
	E peek();

	/**
	 * 获取栈的大小
	 *
	 * @return
	 */
	int count();

	/**
	 * 展示栈内内容
	 */
	void display();
}
