package com.chao.pattern.proxy.static_proxy;

// 创建代理（中介）角色，与房东实现相同接口
public class Proxy implements RentOut
{
    private HouseHolder houseHolder; // 代理角色内部含有真实角色的引用
        
    // 重写租房方法，添加中介操作
    @Override
    public void rentOut() {
        this.preRentOut(); // 代理对象添加自己的操作

        houseHolder.rentOut();//真是对象进行的操作

        this.postRentOut(); // 代理对象添加自己的操作
    }
    
    // 中介操作，租房前收中介费
    public void preRentOut()
    {
        System.out.println("I need more money!");
    }
    
    // 中介操作，租房后扣押金
    public void postRentOut()
    {
        System.out.println("I will deduct some money!");
    }

}