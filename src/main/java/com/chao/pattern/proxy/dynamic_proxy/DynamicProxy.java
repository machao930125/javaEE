package com.chao.pattern.proxy.dynamic_proxy;
// 创建动态代理类，实现代码运行过程中对各种真实对象的动态代理
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler
{
    private Object realSubject;
    
    public DynamicProxy(Object realSubject)
    {
        this.realSubject = realSubject;
    }
    
    public void setRealSubject(Object realSubject)
    {
        this.realSubject = realSubject;
    }


    @Override
    // 实现InvocationHandler接口的 invoke 方法，当代理类调用真实对象的方法时，
    // 将直接寻找执行 invoke 方法。
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        this.preRent(); // 执行代理自己添加的行为操作
        
        method.invoke(realSubject, args); // 以反射（reflection）的形式引用真实对象的方法
        
        this.postRent(); // 执行代理自己添加的行为操作
        return null;
    }
    
    // 代理类自行添加的行为
    public void preRent()
    {
        System.out.println("I need more money!");
    }
    
    // 代理类自行添加的行为
    public void postRent()
    {
        System.out.println("I will deduct some money!");
    }
}