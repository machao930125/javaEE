package com.chao.interview_question;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK {

    public static void main(String[] args) {

        int[] a = { 10, 17, 3, 4, 5, 6, 7, 16, 9, 10, 11, 12, 13, 14, 15, 8 };
        String str = "";
        Integer integer = 1;
        int i = stringSize(11);
        System.out.println(i);

       /* int[] b = topK(a, 4);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + ", ");
        }*/
        /*getTopK(a, 10);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }*/

        /*int partition = partition(a, 0, a.length - 1);
        System.out.println(partition);*/

        /*int largest = findKthLargest(a, 4);
        System.out.println(largest);*/
    }
    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    // Requires positive x
    static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(4,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int num : nums) {
            if (minQueue.size() < k || num > minQueue.peek())
                minQueue.offer(num);
            if (minQueue.size() > k)
                minQueue.poll();
        }
        return minQueue.peek();
    }

    /**
     * 使用堆排算法
     * @param array
     * @param index
     * @param length
     */
    public static void heapify(int[] array, int index, int length) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < length && array[left] > array[index]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (index != largest) {
            swap(array, largest, index);
            heapify(array, largest, length);
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void buildHeap(int[] array) {
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, i, length);
        }
    }

    public static void setTop(int[] array, int top) {
        array[0] = top;
        heapify(array, 0, array.length);
    }

    public static int[] topK(int[] array, int k) {
        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = array[i];
        }
        //先建堆，然后依次比较剩余元素与堆顶元素的大小，比堆顶小的，
        // 说明它应该在堆中出现，则用它来替换掉堆顶元素，然后沉降。
        buildHeap(top);
        for (int j = k; j < array.length; j++) {
            int temp = top[0];
            if (array[j] < temp) {
                setTop(top, array[j]);
            }
        }
        return top;
    }

    /**
     * 使用快排算法
     * @param array
     * @param low
     * @param hight
     * @return
     */
    // 分治
    public static int partition(int[] array, int low, int hight) {
        if (array != null && low < hight) {
            int flag = array[low];
            while (low < hight) {
                while (low < hight && array[hight] >= flag) {
                    hight--;
                }
                array[low] = array[hight];
                while (low < hight && array[low] <= flag) {
                    low++;
                }
                array[hight] = array[low];
            }
            array[low] = flag;
            return low;
        }
        return 0;
    }

    public static void getTopK(int[] array, int k) {
        if (array != null && array.length > 0) {
            int low = 0;
            int hight = array.length - 1;
            int index = partition(array, low, hight);
            //不断调整分治的位置，直到position = k-1
            while (index != k - 1) {
                //大了，往前调整
                if (index > k - 1) {
                    hight = index - 1;
                    index = partition(array, low, hight);
                }
                //小了，往后调整
                if (index < k - 1) {
                    low = index + 1;
                    index = partition(array, low, hight);
                }
            }
        }
    }

}