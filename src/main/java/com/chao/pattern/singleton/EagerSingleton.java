package com.chao.pattern.singleton;

/**
 * Created by machao on 2018/3/15.
 */
public class EagerSingleton {
    //私有化构造器，禁止外部调用构造器创建对象
    private EagerSingleton(){
    }
    //提供一个对象
    private static EagerSingleton instance = new EagerSingleton();

    //向外暴露一个获取对象的方法
    public static EagerSingleton GetInstance(){
        return instance;
    }
}
