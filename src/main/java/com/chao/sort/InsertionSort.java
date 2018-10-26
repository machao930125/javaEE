package com.chao.sort;

/**
 *
 * @author Admin
 * @date 2018/10/26
 */
public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = {7,9,2,5,4};
		insertionSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void insertionSort(int[] arr){
		int length = arr.length;
		if (length <= 1){
			return ;
		}
		for (int i = 1; i < length; i++) {
			int value = arr[i];
			// 从后向前减少数据移动次数
			for (int j = i - 1; j >= 0; j--) {
				if (value < arr[j]){
					arr[j+1] = arr[j];
				}else{
					break;
				}
				arr[j] = value;
			}
		}
	}
}
