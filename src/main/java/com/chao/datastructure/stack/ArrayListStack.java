package com.chao.datastructure.stack;

import java.util.ArrayList;

/**
 *
 * @author machao
 * @date 2018/10/22
 */
public class ArrayListStack<E> implements Stack<E> {

	/**
	 * 数据存储
	 */
	private ArrayList<E> list;
	/**
	 * 栈大小
	 */
	private int size;

	public ArrayListStack(int capacity){
		list = new ArrayList<>(capacity);
		size = 0;
		return ;
	}

	public ArrayListStack(){
		this(10);
	}

	@Override
	public int push(E e) {
		list.add(e);
		size ++;
		return 1;
	}

	@Override
	public E pop() {
		E e = list.get(size - 1);
		// 注意 -- size 和size -- 的区别
		list.remove(-- size);
		return e;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E peek() {
		return list.get(size - 1);
	}

	@Override
	public int count() {
		return size;
	}

	@Override
	public void display(){
		System.out.println(list);
	}
}
