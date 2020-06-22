package com.chao;

public class TestDis {
    public static void main(String[] args) {
        int[] A = {3,4,5,6,8,9,11};
        int first = getFirst(A);
        System.out.println(first);
    }


    public static int getFirst(int[] A){
        int left = 0;
        int right = A.length-1;

        while (left < right){
            if (A[(left + right)/2] > A[left] + (left + right)/2 - left){
                right = (left + right)/2;
            }
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i-1] > 1){
                return i;
            }
        }
        return 0;
    }


    public int getDis(int[] A, int n) {
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
