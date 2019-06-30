package com.chao.pattern.adaptor.class_adaptor;

/**
 * Created by machao on 2018/3/14.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("===============类适配器==============");
        Mobile mobile = new Mobile();
        mobile.charging(new VoltageAdapter());
    }
}
