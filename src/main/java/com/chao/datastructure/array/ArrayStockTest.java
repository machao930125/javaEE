package com.chao.datastructure.array;

/**
 * 数组股票最高收益，以下数组代表每日股票价格
 * {1,5,8,3,5,8,2}
 * 1、允许多次交易
 * 收益：7 + 5 = 12
 * 2、只允许一次交易
 * 收益：7
 * 3、卖出后一天为冻结日，不允许买入
 */
public class ArrayStockTest {
    public static void main(String[] args) {
        int[] arr = {5, 8, 3, 5, 9, 2, 5};
        int calc = calc(arr);
        System.out.println(calc);

        int[] arr1 = {1};
        int i = calcMax(preDeal(arr1));
        System.out.println(i);
    }

    /**
     * 允许多次交易
     *
     * @param arr
     * @return
     */
    public static int calc(int[] arr) {
        int sum = 0;
        int start = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (start < arr[i]) {
                sum += arr[i] - start;
            }
            start = arr[i];
        }
        return sum;
    }

    /**
     * 预处理数组
     *
     * @param arr
     * @return
     */
    public static int[] preDeal(int[] arr) {
        if (arr == null) {
            return new int[]{0};
        }
        int[] temp = new int[arr.length];
        temp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            temp[i] = arr[i] - arr[i - 1];
        }
        return temp;
    }

    /**
     * @param preArr
     * @return
     */
    public static int calcMax(int[] preArr) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < preArr.length; i++) {
            max = Math.max(max, temp);
            temp += preArr[i];
            if (temp < 0) {
                temp = 0;
            }
        }
        return max;
    }
}
