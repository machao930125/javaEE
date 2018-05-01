package com.chao.map;

import java.awt.image.Kernel;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2018/4/13.
 *
 * 这个类用于演示treemap排序功能
 *
 */
public class TreeMapSort {

    public static void main(String[] args) {
        //创建hashmap,并存放数据
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("d",5);
        treeMap.put("a",8);
        treeMap.put("c",3);
        treeMap.put("b",3);
        treeMap.forEach((k,v)->{
            System.out.println("K:" + k + ", v:" + v);
        });
        //调用操作方法
        defaultSout(treeMap);
    }


    /**
     * 按照treemap默认方式进行排序
     *
     * @param map
     */
    private static  void defaultSout(TreeMap<String,Integer> map){
        Stream<Map.Entry<String, Integer>> stream = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed());
        System.out.println(stream);
    }
}
