package com.chao.datastructure;

/**
 * 递归
 *
 * @author chao
 */
public class Recursive {
    public static String str = "123456789";

    /**
     * 测试递归前后的区别，前为递，后为归
     *
     * @param count
     */
    public static void testBefore(int count) {
        int length = str.length();
        // 递归出口条件
        if (count >= length) {
            return;
        }
        // count ++ 保证变量增加 ，正序输出
        System.out.println(str.charAt(count++));
        testBefore(count);
        // 逆序输出
        System.out.println(str.charAt(count - 1));
    }

    /**
     * 测试
     */
    public static class Test {
        public static void main(String[] args) {
            testBefore(0);
        }
    }
}
