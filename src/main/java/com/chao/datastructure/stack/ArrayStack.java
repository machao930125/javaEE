package com.chao.datastructure.stack;

/**
 * @author machao
 * @date 2018/10/22
 */
public class ArrayStack<E> implements Stack<E> {
	/**
	 * 栈的数据存储
	 */
	private E[] data;
	/**
	 * 栈的数据量  注意这里不能使用length，因为数组初始化之后length是一个固定值
	 */
	private int size;

	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	public ArrayStack() {
		this(10);
	}

	@Override
	public int push(E o) {
		data[size] = o;
		size++;
		return 1;
	}

	@Override
	public E pop() {
		E e = data[size - 1];
		data[size - 1] = null;
		size--;
		return e;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E peek() {
		return data[size - 1];
	}

	@Override
	public int count() {
		return size;
	}

	@Override
	public void display() {
		for (E datum : data) {
			System.out.println(datum);
		}
	}
}
