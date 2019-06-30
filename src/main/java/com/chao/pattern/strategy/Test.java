package com.chao.pattern.strategy;

import java.util.Arrays;

/**
 * 策略模式可以将高层算法和底层的具体实现细节分离，允许高层的算法独立于具体的细节而重用，
 * 具体细节独立于高层算法而重用。而模板方法不能实现具体细节独立于高层算法存在。
 * spring中的jdbc使用到模板方法和策略设计模式。
 */
public class Test {

    public static void main(String[] args) {
        //对整型数组排序
        int[] intArray = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        BubbleSorter<int[]> intBubbleSorter = new BubbleSorter<>(new IntSortHandler());
        int operations = intBubbleSorter.sort(intArray);
        System.out.println("[Strategy] operations:" + operations + ", array:" + Arrays.toString(intArray));

    }
}