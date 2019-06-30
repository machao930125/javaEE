package com.chao.pattern.singleton;

/**
 * Created by machao on 2018/3/15.
 */
public class LazySingleton {
    private LazySingleton(){}

    private static LazySingleton instance ;

    public static synchronized  LazySingleton getInstance(){
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }
}
