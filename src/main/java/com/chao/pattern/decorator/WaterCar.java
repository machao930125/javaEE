package com.chao.pattern.decorator;

//ConcreteDecorator具体装饰角色
class WaterCar extends SuperCar{

    public WaterCar(ICar car) {
        super(car);
    }
    
    public void swim(){
        System.out.println("水里游");
    }
    
    @Override
    public void move() {
        super.move();
        swim();
    }
}