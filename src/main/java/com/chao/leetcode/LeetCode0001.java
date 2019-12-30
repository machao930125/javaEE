package com.chao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class LeetCode0001 {
    /**
     * 通过map来降低查询时间
     * 循环两遍
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        // 将数据存储在map中
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 定义返回数组
        int[] ints = new int[2];
        // 通过目标结果和第一个值做差，获取结果进行get
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            Integer index = map.get(result);
            if (index != null && i != index) {
                ints[0] = i;
                ints[1] = index;
                return ints;
            }
        }
        return null;
    }

    /**
     * 通过map降低查询时间，一遍遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        // 将数据存储在map中
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 测试
     */
    static class Test {
        public static void main(String[] args) {
            int[] nums = {2, 7, 11, 15};
            int[] ints = twoSum1(nums, 9);
            int[] ints1 = twoSum2(nums, 9);
            System.out.println();
        }
    }
}
