package com.chao.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class Test0001 {

    /**
     * 暴力求解法：
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] temp = {};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    temp = new int[]{i, j};
                }
            }
        }
        return temp;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] temp = {};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int stemp = target - nums[i];
            if (map.containsKey(stemp)) {
                Integer integer = map.get(stemp);
                if (integer != i) {
                    temp = new int[]{i, integer};
                }
            }
        }
        return temp;
    }


    public int[] twoSum3(int[] nums, int target) {
        int[] temp = {};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int stemp = target - nums[i];
            if (map.containsKey(stemp)) {
                Integer integer = map.get(stemp);
                if (integer != i) {
                    temp = new int[]{i, integer};
                }
            }
            map.put(nums[i], i);
        }
        return temp;
    }


}
