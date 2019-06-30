package com.chao.pattern.proxy.dynamic_proxy;
//创建客户类
import java.lang.reflect.Proxy;

/**
 * 代理模式解决了不能直接操作真实对象的问题，其中的动态代理更是使代理模式的使用简化不少。
 * 若使用静态代理，那么当有不用的真实对象（分别实现了不同的操作接口），
 * 我们只能去为被代理的真实对象重新生成一个代理类，而动态代理就解决了这一问题，
 * 用一个代理类，解决了所有真实对象的代理。通俗点将，这是个全能的代理，
 * 既能干租房中介的活，还能干买菜中介的活，也能干媒人的活，听起来貌似很牛逼的样子。
 */
public class Client
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        HouseHolder houseHolder = new HouseHolder();
        // 生成 HouseHolder 的代理
        DynamicProxy handler = new DynamicProxy(houseHolder);

        // 动态生成代理实例（HouseHold代理实例），代理支持的接口由初始化参数（第二个）指定，
        // 代理实例处理操作所调用的 handler 由第三个参数指定
        Rent rent = (Rent)Proxy.newProxyInstance(HouseHolder.class.getClassLoader(),
                HouseHolder.class.getInterfaces(), handler);
        rent.rent(); // 执行客户需要进行的行为操作，动态生成的代理实例直接调用指定 handler 的 invoke 方法
        
        System.out.println("----------------------------------");
        
        BusinessMan businessMan = new BusinessMan();
        // 为代理更换引用的真实对象（即原本被代理的 HouseHolder 被更换为了 BusinessMan）
        handler.setRealSubject(businessMan);
        // 动态生成代理实例（BusinessMan代理实例）
        // 注：代理实例实在代码执行过程中动态执行的
        Sale sale = (Sale)Proxy.newProxyInstance(BusinessMan.class.getClassLoader(),
                BusinessMan.class.getInterfaces(), handler);
        sale.sale();        
    }
}