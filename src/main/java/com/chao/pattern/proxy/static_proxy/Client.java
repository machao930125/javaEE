package com.chao.pattern.proxy.static_proxy;

// 租房客户类
public class Client
{
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 涉世未深的小年轻要租房，苦于联系不到房东，只能通过中介
        RentOut rentOut = new Proxy();
        rentOut.rentOut();
    }
}