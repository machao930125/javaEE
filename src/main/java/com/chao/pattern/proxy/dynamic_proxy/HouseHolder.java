package com.chao.pattern.proxy.dynamic_proxy;

// 创建房主类（真实角色），实现租房接口
public class HouseHolder implements Rent
{
    @Override
    public void rent()
    {
        System.out.println("HouseHolder: I’m renting the house!");        
    }
}