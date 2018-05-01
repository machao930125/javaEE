package com.chao.Java8;

import com.chao.domain.User;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2018/4/14.
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        list.add(new User("a",15));
        list.add(new User("g",19));
        list.add(new User("d",29));
        list.add(new User("y",27));
        list.add(new User("y",27));
        list.add(new User("k",35));
        list.add(new User("w",23));
        list.add(new User("h",43));
        list.add(new User("r",98));
        list.add(new User("v",25));
        list.add(new User("b",65));
        list.add(new User("e",58));

        System.out.println("---------------------年龄大于18------------------------");
        //集合中user的年龄大于18的数量
        long count = list.stream().filter((u) -> u.getAge() > 18).count();
        System.out.println(count);
        //获取集合中年龄大于18的所有人
        List<User> users = list.stream().filter((u) -> u.getAge() > 18).collect(Collectors.toList());
        users.forEach(System.out::println);

        System.out.println("---------------------找出年龄最大的人------------------------");
        Optional<User> max = list.stream().max((u1, u2) -> u1.getAge().compareTo(u2.getAge()));
        System.out.println(max.get());
        Optional<User> min = list.stream().min((u1, u2) -> u1.getAge().compareTo(u2.getAge()));
        System.out.println(min.get());

        System.out.println("---------------------映射-归纳~求出所有人的年龄的总和------------------------");
        Optional<Integer> reduce = list.stream().map(User::getAge).reduce(Integer::sum);
        System.out.println(reduce.get());

        System.out.println("---------------------按照年龄进行排序------------------------");
        list.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList())
            .forEach(System.out::println);

        System.out.println("---------------------按照年龄进行分组------------------------");
        Map<Integer, List<User>> map = list.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(map);

        System.out.println("---------------------集合去重------------------------");
        long count1 = list.stream().distinct().count();
        System.out.println(count1);
        Stream.of(new User("u" ,21),new User("u",21));


    }
}
