package com.chao.datastructure.stack;

/**
 *
 * @author machao
 * @date 2018/10/22
 */
public class ArrayListStackTest {
	public static void main(String[] args) {
		ArrayListStack<Integer> arrayStack = new ArrayListStack<>();
		System.out.println("栈内是否为空：" + arrayStack.isEmpty());
		arrayStack.display();
		for (int i = 0; i < 10; i++) {
			arrayStack.push(i);
		}
		arrayStack.display();
		System.out.println("栈顶元素：" + arrayStack.peek());
		System.out.println("出栈元素：" + arrayStack.pop());
		System.out.println("出栈元素：" + arrayStack.pop());
		System.out.println("栈顶元素：" + arrayStack.peek());
		System.out.println("栈内是否为空：" + arrayStack.isEmpty());
		System.out.println("栈的大小：" + arrayStack.count());
		arrayStack.display();
	}
}
