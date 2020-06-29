package com.chao.datastructure.array;

/**
 * 两数相乘
 */
public class TwoIntTest {
    public static void main(String[] args) {
        int a = 25666676;
        int b = 14;
        mul(a, b);
        System.out.println(a * b);
    }

    public static void mul(int a, int b) {
        int[] result = new int[20];

        // 两个整数指针
        int k = 0;
        int j = 0;
        while (a > 0) {
            int tempa = a % 10;
            a = a / 10;
            j = 0;
            int bb = b;
            while (bb > 0) {
                int tempb = bb % 10;
                bb = bb / 10;
                int rt = tempa * tempb;
                int cur = rt % 10;
                int next = rt / 10;
                // 赞不考虑进位问题
                result[k + j] = result[k + j] + cur;
                result[k + j + 1] = result[k + j + 1] + next;
                j++;
            }
            k++;
        }

        for (int i = 0; i < result.length - 1; i++) {
            if ((result[i] / 10) > 0) {
                result[i + 1] = result[i] / 10 + result[i + 1];
                result[i] = result[i] % 10;
            }
        }

        boolean rr = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] > 0) {
                rr = true;
            }
            if (rr) {
                System.out.print(result[i]);
            }
        }
        System.out.println();
    }
}
