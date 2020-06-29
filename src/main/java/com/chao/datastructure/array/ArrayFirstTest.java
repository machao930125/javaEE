package com.chao.datastructure.array;

/**
 * 查找第一个不递增的数
 */
public class ArrayFirstTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int first = findFirst(arr);
        int first2 = findFirst2(arr);
        System.out.println(first + ":" + first2);
    }

    public static int findFirst(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - arr[i - 1]) > 1) {
                return i;
            }
        }
        return -1;
    }

    public static int findFirst2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int mid = left + ((right - left) >> 1);
        while (left < right) {
            if (arr[mid] > arr[left] + mid - left) {
                right = mid;
            }
            if (arr[mid] == arr[left] + mid - left) {
                left = mid;
            }
            if ((right - left) == 1) {
                if (arr[right] - arr[left] != 1) {
                    return right;
                }
                return -1;
            }
            mid = left + ((right - left) >> 1);
        }
        return -1;
    }
}
