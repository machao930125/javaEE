package com.chao.pattern.delegate;

/**
 * Created by machao on 2018/3/17.
 */
public class B {
    A a = new A();
    void method1(){
       a.method1();
    }
    void method2(){
       a.method2();
    }
}
