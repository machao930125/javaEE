package com.chao.leetcode;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author chao
 */
public class LeetCode0027 {

    /**
     * 采用双指针的方式遍历数组
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        // 临界值处理
        if (nums.length == 0) {
            return 0;
        }
        // 定义指针
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    static class Test {
        public static void main(String[] args) {
            int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
            int i = removeElement(nums, 2);
            System.out.println(i);
        }
    }
}
