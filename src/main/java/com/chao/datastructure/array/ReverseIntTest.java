package com.chao.datastructure.array;

public class ReverseIntTest {
    public static void main(String[] args) {
        int a = 23501;
        reverse(a);
    }
    public static void reverse(int a) {
        int b = 0;
        while (a != 0) {
            int temp = a % 10;

            if ((b == Integer.MAX_VALUE / 10 && temp > 7) || b > Integer.MAX_VALUE / 10) {
                System.out.println(0);
            }
            if ((b == Integer.MIN_VALUE / 10 && temp < -8) || b < Integer.MIN_VALUE / 10) {
                System.out.println(0);
            }
            b = b * 10 + temp;
            a = a / 10;
        }
        System.out.println(b);
    }
}
