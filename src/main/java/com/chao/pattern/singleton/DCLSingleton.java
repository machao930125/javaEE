package com.chao.pattern.singleton;

/**
 * 双检锁单例设计模式
 *
 * Created by machao on 2019/6/30.
 */
public class DCLSingleton {
	private DCLSingleton() {
	}

	private static volatile DCLSingleton instance;

	public static DCLSingleton getInstance() {
		if (instance == null) {
			synchronized (DCLSingleton.class) {
				if (instance == null) {
					instance = new DCLSingleton();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		DCLSingleton instance = DCLSingleton.getInstance();
		System.out.println();
	}

}
