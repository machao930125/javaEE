package com.chao.pattern.proxy.static_proxy;


// 创建房主类（真实角色）
public class HouseHolder implements RentOut {
    @Override
    public void rentOut() {
        System.out.println("I’m renting the house!");
    }
}