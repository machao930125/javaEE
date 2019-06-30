package com.chao.pattern.decorator;

//ConcreteComponent 具体构件角色(真实对象)
class Car implements ICar{

    @Override
    public void move() {
        System.out.println("陆地上跑！");
    }
    
}