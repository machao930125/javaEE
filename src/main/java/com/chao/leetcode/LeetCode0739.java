package com.chao.leetcode;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 */
public class LeetCode0739 {
    /**
     * 使用栈来实现
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        int[] ints = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ints[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ints;
    }

    /**
     * 测试
     */
    static class Test {
        public static void main(String[] args) {
            int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
            int[] ints1 = dailyTemperatures(temperatures);
            System.out.println(ints1);
        }
    }


}
