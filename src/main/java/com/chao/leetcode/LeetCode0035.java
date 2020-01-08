package com.chao.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class LeetCode0035 {
    /**
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // 判断临界值
            if (i == nums.length - 1) {
                if (nums[i] == target){
                    return i;
                }else if (nums[i] > target){
                    return 0;
                }
                return nums.length;
            }
            // 查询数据所在位置
            if (target > nums[i] && target <= nums[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    public static int searchInsert2(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (nums[len - 1] < target) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // nums[mid] 的值可以舍弃
                left = mid + 1;
            } else {
                // nums[mid] 不能舍弃
                right = mid;
            }
        }
        return right;
    }



    static class Test {
        public static void main(String[] args) {
            int[] nums = {1};
            int i = searchInsert(nums, 0);
            System.out.println(i);
        }
    }
}
