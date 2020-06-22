package com.chao;

public class TestDis {
    public static void main(String[] args) {
        int[] A = {9, 11, 13, 19};
        int first = getFirst(A);
        int first2 = getFirst2(A);
        System.out.println(first2);
        System.out.println(first);
    }

    public static int getFirst2(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int count = A[i] - A[i - 1];
            if (count > 1) {
                return i;
            }
        }
        return -1;
    }

    public static int getFirst(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (A[mid] > A[left] + mid - left) {
                right = mid;
            }
            if (A[mid] == A[left] + mid - left) {
                left = mid;
            }
            if (right - left == 1) {
                return right;
            }
        }
        return -1;
    }


    public static int getDis(int[] A, int n) {
        // write code here
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[j] - A[i] > max) {
                    max = A[j] - A[i];
                }
            }
        }

        return max;

    }
}
