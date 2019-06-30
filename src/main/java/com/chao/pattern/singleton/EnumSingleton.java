package com.chao.pattern.singleton;

/**
 * Created by machao on 2018/3/15.
 */
public enum EnumSingleton {
    INSTANCE;
    public void say(){
        System.out.println("我是枚举单例");
    }
}
