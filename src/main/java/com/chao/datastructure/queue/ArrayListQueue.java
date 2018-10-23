package com.chao.datastructure.queue;

import java.util.ArrayList;

/**
 *
 * @author Admin
 * @date 2018/10/23
 */
public class ArrayListQueue<E> implements queue<E> {

	private ArrayList<E> list;

	public ArrayListQueue(int capacity){
		list = new ArrayList<>(capacity);
	}

	public ArrayListQueue(){
		this(10);
	}

	@Override
	public void push(E e) {
		list.add(e);
	}

	@Override
	public E pop() {
		E e = null;
		if (list.size() != 0){
			e = list.get(0);
			list.remove(0);
		}
		return e;
	}

	@Override
	public int count() {
		return list.size();
	}

	@Override
	public void display() {
		System.out.println(list);
	}
}
