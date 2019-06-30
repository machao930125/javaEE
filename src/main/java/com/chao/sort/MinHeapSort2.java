package com.chao.sort;

/**
 * Created by Admin on 2018/11/2.
 */
public class MinHeapSort2 {
	void AdjustDown(int arr[], int i, int n)
	{
		//子节点
		int j = i * 2 + 1;
		while (j<n)
		{
			//子节点中找较小的
			if (j+1<n && arr[j] > arr[j + 1])
			{
				j++;
			}
			if (arr[i] < arr[j])
			{
				break;
			}
			swap(arr[i],arr[j]);
			i = j;
			j = i * 2 + 1;
		}
	}
	void MakeHeap(int arr[], int n)//建堆
	{
		int i = 0;
		//((n-1)*2)+1 =n/2-1
		for (i = n / 2 - 1; i >= 0; i--)
		{
			AdjustDown(arr, i, n);
		}
	}
	void HeapSort(int arr[],int len)
	{
		int i = 0;
		MakeHeap(arr, len);
		for (i = len - 1; i >= 0; i--)
		{
			swap(arr[i], arr[0]);
			AdjustDown(arr, 0, i);
		}

	}
	void swap(int a,int b){
		int temp = 0;
		temp = a;
		b = a;
		a = temp;
	}
}
