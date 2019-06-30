package com.chao.pattern.proxy.dynamic_proxy;

// 创建商人类（真实对象），实现售卖接口
public class BusinessMan implements Sale
{
    @Override
    public void sale()
    {
        System.out.println("BusinessMan: I'm salling something!");
    }
}