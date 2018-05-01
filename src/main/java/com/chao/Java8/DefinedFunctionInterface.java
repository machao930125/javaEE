package com.chao.Java8;

/**
 * Created by Administrator on 2018/4/14.
 */
public class DefinedFunctionInterface {
    public static void main(String[] args) {
        NumberOperation<Integer, Integer> numberOperation = new NumberOperation<>(5, 6);
        Integer integer = numberOperation.calator((n1, n2) -> n1 + n2 );
        System.out.println(integer);
    }
}

/**
 * 1、自定义一个函数式接口
 *
 */
@FunctionalInterface
interface Calator<N,V>{
    V operation(N o1 ,N o2);
}

/**
 * 2、新建一个引用函数式接口的类
 *
 */
class NumberOperation<N extends Number,V extends Number>{
    private N n1;
    private N n2;

    public NumberOperation(N n1, N n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public V calator(Calator<N,V> calator){
        return calator.operation(n1,n2);
    }
}


