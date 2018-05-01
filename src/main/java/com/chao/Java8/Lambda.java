package com.chao.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 用途
 * 1、只有一个抽象方法的函数式接口
 * 2、集合批量操作
 * 3、流操作
 *
 * Created by Administrator on 2018/4/14.
 */
public class Lambda {
    public static void main(String[] args) {
        //1、只有一个抽象方法的函数式接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("原始方式启动");
            }
        }).start();
        new Thread(() -> run("t1")).start();
        new Thread(() -> {
            System.out.println("t2");
        }).start();
        Runnable runnable = () -> System.out.println("t3");
        new Thread(runnable).start();

        //2、集合批量操作
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach((e) -> System.out.println(e));

        //3、流操作
        long count = list.stream().filter((e) -> "a".equals(e)).count();
        System.out.println(count);
    }

    public static void run(String str){
        System.out.println(str);
    }
}
