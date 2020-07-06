package com.chao.leetcode;

class Solution {
    public int search(int[] arr, int target) {
        int low = 0;
        int hight = arr.length - 1;
        int mid = 0;
        while (low < hight) {
            mid = low + (low + hight) / 2;
            if (arr[mid] > target) {
                low = mid + 1;
            }else if (arr[mid] < target){
                low = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
