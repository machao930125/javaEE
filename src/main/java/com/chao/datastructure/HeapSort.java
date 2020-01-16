package com.chao.datastructure;

/**
 * 堆排序
 *
 * @author chao
 */
public class HeapSort {

    /**
     * 交换数组两个元素值
     *
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 调整堆
     *
     * @param arr
     * @param start
     * @param end
     */
    private static void adjustHeap(int[] arr, int start, int end) {
        while (true) {
            // 当列表第一个是以下标0开始，结点下标为i,左孩子则为2*i+1,右孩子下标则为2*i+2;
            int left_child = start * 2 + 1;
            if (left_child > end) {
                break;
            }
            // 大顶堆，左节点值大于右节点值
            if (left_child + 1 <= end && arr[left_child + 1] > arr[left_child]) {
                left_child += 1;
            }
            // 如果父节点小于子节点进行更换
            if (arr[start] < arr[left_child]) {
                swap(arr, start, left_child);
                // 继续向下调整
                start = left_child;
            } else {
                break;
            }
        }
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    private static void heapSort(int[] arr) {
        // 1、创建大顶堆，从最后一个有孩子节点的节点开始创建堆
        int last = arr.length / 2 - 1;
        for (int i = last; i >= 0; i--) {
            adjustHeap(arr, i, arr.length - 1);
        }

        // 2、将最大值放到最后，调整堆
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i - 1);
        }
    }

    /**
     * 利用大顶堆获取最小的N个值
     *
     * @param arr
     * @param n
     */
    public static void topN(int[] arr, int n) {
        // 创建大顶堆
        int start = n / 2 - 1;
        for (int i = start; i >= 0; i--) {
            adjustHeap(arr, i, n - 1);
        }
        // 一次比较大小，交换后进行堆调整
        for (int i = n; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                swap(arr, i, 0);
                adjustHeap(arr, 0, n - 1);
            }
        }
    }

    /**
     * 测试类
     */
    public static class Test {
        public static void main(String[] args) {
            int[] array = {16, 7, 3, 20, 17, 8, 10, 9};
            // 测试topN
            topN(array, 5);
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
            // 测试堆排序
            heapSort(array);
            for (int i : array) {
                System.out.print(i + " ");
            }
        }
    }

}