package com.chao.algorizhm;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/4/22.
 */
public class DubbleSort {
    public static  void dubbleSort(int[] obj){
        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj.length-1; j++) {
                if (isBig(obj,j)){
                    swapp(obj,j);
                }
            }
        }
    }

    public static Boolean isBig (int[] obj,int j){
        return obj[j] > obj[j+1];
    }

    public static void swapp(int[] obj, int j){
        int temp = obj[j];
        obj[j] = obj[j+1];
        obj[j+1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9,1,5,8,3,2,6,5,9,8};
        System.out.println(Arrays.toString(arr));
        Arrays.asList(arr).stream().forEach(s-> System.out.println(s));
        dubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.asList(arr).stream().forEach(s-> System.out.println(s));
    }
}
