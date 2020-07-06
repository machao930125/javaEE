package com.chao.datastructure;

import java.util.LinkedList;
import java.util.List;

public class LinkedListLRU {
    private static List<Object> listLRU = new LinkedList<>();

    public static void init() {
        listLRU.add("a");
        listLRU.add("b");
        listLRU.add("c");
        listLRU.add("d");
        listLRU.add("e");
    }

    public static Object get(){
        return listLRU.get(0);
    }

    public static void add(Object obj) {
        boolean flag = true;
        for (int i = 0; i < listLRU.size(); i++) {
            if (listLRU.get(i).equals(obj)) {
                swap(listLRU,i);
                flag = false;
            }
        }
        if (flag){
            swap(listLRU,listLRU.size() -1);
            listLRU.set(0,obj);
        }
    }

    public static void swap(List list, int end) {
        Object o = list.get(end);
        while (end > 0) {
            list.set(end, list.get(end - 1));
            end = end - 1;
        }
        list.set(0, o);

    }

    public static void main(String[] args) {
        init();
        Object o = get();
        System.out.println(o.toString());
        add("ad");
        System.out.println(get().toString());
        add("e");
        System.out.println(get().toString());
        add("a");
        System.out.println(get().toString());
        System.out.println();



    }

}
