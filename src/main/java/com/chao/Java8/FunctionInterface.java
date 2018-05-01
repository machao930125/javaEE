package com.chao.Java8;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.function.*;

/**
 * Created by Administrator on 2018/4/14.
 */
public class FunctionInterface {
    public static void main(String[] args) {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("hello  functionInterface ....");

        Supplier supplier = () -> {
          return "hello supplier";
        };
        System.out.println(supplier.get());

        //断言
        Predicate<String> predicate  = (x) -> {
            System.out.println(x);
            return x.startsWith("hello");
        };
        System.out.println(predicate.test("hello machao......."));

        //输入一个返回一个
        Function<String,String> function = (x) -> {
            System.out.println(x + ": ");
            return "function";
        };
        System.out.println(function.apply("hello"));

        //输入两个进行操作，返回一个
        BinaryOperator<String> binaryOperator = (x,y) -> {
            return x + y;
        };
        System.out.println(binaryOperator.apply("hello", "machao"));
    }
}
