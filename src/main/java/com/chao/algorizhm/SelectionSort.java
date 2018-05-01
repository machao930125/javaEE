package com.chao.algorizhm;

import java.time.temporal.Temporal;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/4/23.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,9,5,3};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr){
        //表示最小的元素
        int minEle = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            //每一轮第一个比较的元素
            minEle = i;

            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[i] > arr[j]){
                    minEle = j;
                }
            }
            if (minEle != i)
                swap(arr,minEle,i);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
