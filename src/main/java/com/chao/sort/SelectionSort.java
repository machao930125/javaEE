package com.chao.sort;

/**
 *
 * @author Admin
 * @date 2018/10/26
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr={1,3,2,45,65,33,12};
		selectionSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void selectionSort(int[] arr){
		int length = arr.length;
		if (length <= 1){
			return;
		}

		for (int i = 0; i < length; i++) {
			int index = i;
			for (int j = i; j < length; j++) {
				if (arr[j] < arr[index]){
					index = j;
				}
			}
			if (index != i){
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
