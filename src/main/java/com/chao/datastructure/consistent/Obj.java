package com.chao.datastructure.consistent;

/**
 * 实际存储对象，很简单的一个类，只需要获取他的 hash 值就好：
 */
public class Obj {

	String key;

	Obj(String key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		return key.hashCode();
	}

	@Override
	public String toString() {
		return "Obj{" +
				"key='" + key + '\'' +
				'}';
	}
}