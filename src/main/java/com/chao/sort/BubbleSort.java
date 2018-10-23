package com.chao.sort;

/**
 *
 * @author Admin
 * @date 2018/10/23
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {2,7,9,5,4,7,8};
		bubbleSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
 	}
	public static void bubbleSort(int[] a) {
		int length = a.length;
		if (length <= 1) {
			return;
		}

		for (int i = 0; i < length; i++) {
			boolean flag = false;
			for (int j = 0; j < length - i - 1; j++) {
				if (a[j] > a[j + 1]){
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag){
				break;
			}
		}

	}

}
