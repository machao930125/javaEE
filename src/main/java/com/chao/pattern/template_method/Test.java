package com.chao.pattern.template_method;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        //对整型数组排序
        int[] intArray = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int operations = new Sorter_design().sort(intArray);
        System.out.println("[Template Method] operations:" + operations + ", array:" + Arrays.toString(intArray));

    }
}