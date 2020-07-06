package com.chao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test0003 {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        List<String> list = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < length; i++) {
            if (list.contains(chars[i]+"")) {
                temp = temp < list.size() ? list.size() : temp;
                list.clear();
            }
                list.add(chars[i]+"");


        }
        return temp < list.size() ? list.size() : temp;
    }

    public static void main(String[] args) {
        String s = " ";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
