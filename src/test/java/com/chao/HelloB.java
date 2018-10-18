package com.chao;

import lombok.Builder;

/**
 * Created by Admin on 2018/10/18.
 */
public class HelloB extends HelloA {
	public HelloB(){
		System.out.println("HelloB");
	}
	{
		System.out.println("I'm B class");
	}
	static {
		System.out.println("static B");
	}

	public static void test(){
		System.out.println("test B method");
	}

	public static void main(String[] args) {
		new HelloA().test();
	}
}
