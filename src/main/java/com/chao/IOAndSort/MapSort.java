package com.chao.IOAndSort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by machao on 2018/4/13.
 */
public class MapSort {
    public static void main(String[] args) {
        // 创建map
        Map<String, Integer> maps = new HashMap<String, Integer>();
        maps.put("12", 12);
        maps.put("11", 11);
        maps.put("2", 2);

        // 输出 初始化后的map
        maps.forEach((k, v) -> {
            System.out.println("原始map:" + k + "->" + v);
        });

        /*maps = maps
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue()
                        .reversed())
                .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));*/

        List<Map.Entry<String, Integer>> listMap = maps
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                .collect(Collectors.toList());

        // 排序完后返回list
        listMap.forEach(e -> {
            System.out.println("排序完后返回List<Entry<String, Integer>>:"
                    + e.getKey() + "->" + e.getValue());
        });
        // key值排序
        List<String> list = maps
                .keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());
        maps.forEach((k, v) -> {
            System.out.println("排序完后返回map:" + k + "->" + v);
        });
        list.forEach(e -> {
            System.out.println("key值单独排序返回list<String>:" + e);
        });
    }


}
