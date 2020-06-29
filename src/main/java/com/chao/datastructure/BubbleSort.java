package com.chao.datastructure;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author chao
 */
public class BubbleSort {
    /**
     * 交换位置
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 冒泡排序算法
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                // 两两比较，将大的放在最后
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    result = false;
                }
            }
            // 较少循环次数
            if (result) {
                return;
            }
        }
    }

    /**
     * 测试
     */
    public static class Test {
        public static void main(String[] args) {
            int[] arr = {1, 5, 8, 9, 3, 6, 7, 2, 8, 2, 4, 10, 12};
//            sort(arr);
            bubbleSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swap = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swap = false;
                }
            }
            if (swap) {
                return;
            }
        }
    }
}
