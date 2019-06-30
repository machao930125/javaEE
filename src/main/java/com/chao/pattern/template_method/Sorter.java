package com.chao.pattern.template_method;

import java.util.Arrays;

/**
 * Created by machao on 2018/3/13.
 * 通过冒泡排序演示模板方法设计模式
 */
public class Sorter {
    /*
     * 冒泡排序
     */
    public static int sort(int[] arr){
        int oprations = 0;
        if (arr.length <= 1){
            return oprations;
        }
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1 -j ; i++) {
                oprations ++ ;
                if (arr[i]<arr[i+1]){
                    swap(arr,i);
                }
            }
        }
        return oprations;
    }
    public static void swap(int[] array, int index){
        int stmp = array[index];
        array[index] = array[index+ 1];
        array[index + 1] = stmp;
    }
    public static boolean needSwap(int[] array , int index){
        return array[index] < array[index + 1];
    }

    public static void main(String[] args) {
        int[] a = {1,3,8,4,2};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
