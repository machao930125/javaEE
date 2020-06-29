package com.chao.datastructure.array;

/**
 * 查找数组中最大值
 */
public class ArrayMaxTest {

    public static void main(String[] args) {
        int[] arr = {7, 9, 3, 6, 0, 2, 1, 5};
        int i = maxVal(arr, 0, arr.length - 1);
        System.out.println(i);
        System.out.println((4 >> 1) + 4);
    }

    /**
     * 1、找出数组中最大值
     */
    public static int maxVal(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int mid = left + ((right - left) >> 1);
        int leftMax = maxVal(arr, left, mid);
        int rightMax = maxVal(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }


}
