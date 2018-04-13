package com.chao.IOAndSort;

import java.io.*;
import java.util.*;

/**
 * Created by machao on 2018/4/13.
 */
public class IOAndSort {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return - o1.compareTo(o2);
            }
        });
        map.put(9,"a");
        map.put(1,"b");
        map.put(8,"c");
        map.put(5,"d");
        System.out.println(map);
    }
    public static void readTxt() throws IOException {
        File file = new File("C:/Users/machao/Desktop/test.txt");

        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String s = "";
        String str = "";
        while ((s = bufferedReader.readLine()) !=  null){
            str += s;
        }

        String[] strings = str.split(" ");


        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String string : strings) {
            Integer put = map.put(string, 1);
            if (put != null){
                map.put(string,put+1);
            }
        }

        LinkedList<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        System.out.println(list);
    }

    public static String readTxt(String path) throws IOException {
        File file = new File(path);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String str = "";
        String s = "";

        while ((s = bufferedReader.readLine()) != null ){
            str += s;
        }
        return str;
    }

    public static Map stringToMap(String str){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        String[] words = str.split(" ");

        for (String word : words) {
            Integer put = map.put(word, 1);
            if (put != null ){
                map.put(word,put + 1);
            }
        }
        return map;
    }

    public static List<Map.Entry<String,Integer>> sortMap(Map map){
        LinkedList<Map.Entry<String, Integer>> entries =
                new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return entries;
    }
}
