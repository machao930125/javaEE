package com.chao.leetcode;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author chao
 */
public class LeetCode0026 {
    /**
     * 采用双指针的方式遍历数组
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        // 临界值处理
        if (nums.length == 0) {
            return 0;
        }
        // 定义指针
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[j + 1] = nums[i];
                j++;
            }
        }
        return j + 1;
    }

    static class Test {
        public static void main(String[] args) {
            int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
            int i = removeDuplicates(nums);
            System.out.println(i);
        }
    }

}
