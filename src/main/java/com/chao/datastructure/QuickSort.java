package com.chao.datastructure;

import java.util.Arrays;

/**
 * 快排,左右指针递归求解
 *
 * @author chao
 */
public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        // 临界值判断，递归出口
        if (start >= end) {
            return;
        }
        // 定义左右指针
        int left = start;
        int right = end;

        // 取左侧第一个值作为基准
        int mid = arr[left];
        while (left < right) {
            // 右指针一次向左
            while (left < right && mid <= arr[right]) {
                right -= 1;
            }
            arr[left] = arr[right];
            // 左指针一次向右
            while (left < right && mid > arr[left]) {
                left += 1;
            }
            arr[right] = arr[left];
        }
        arr[left] = mid;

        // 基准两侧一次递归
        quickSort(arr, left + 1, end);
        quickSort(arr, 0, left - 1);
    }

    /**
     * 测试
     */
    public static class Test {
        public static void main(String[] args) {
            int[] array = {16, 7, 3, 20, 17, 8, 10, 9};
            sort(array, 0, array.length - 1);
            System.out.println(Arrays.toString(array));
        }
    }

    public static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int mid = arr[left];

        while (left < right) {
            while (left < right && mid <= arr[right]) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && mid > arr[left]) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = mid;
        sort(arr, left + 1, right);
        sort(arr, 0, left - 1);
    }
}
