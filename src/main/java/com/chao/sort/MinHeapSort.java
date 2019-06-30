package com.chao.sort;
 
import java.util.Random;
 
/******************************8
 * 有十亿条数字，要从中选出最大的1000条，用什么算法最好？
 * 需要考虑空间复杂度和时间复杂度
 * 其中10亿要表达的意思是，内存不能一次装下
 * 
 * 这个算法是“计算机科学中最重要的32个算法”之一
 * 
 * @author Administrator
 *
 */
public class MinHeapSort{
 
    /**
    * 将数组调整为小根堆，即由小到大排序
    */
    public static int[] heap = new int[] { 1,3,7,3,5,2,8,4,6,10,9,11,54,23,13};
     
    public static void initData(int n){
        Random ran = new Random();
        heap = new int[n];
        for(int i=0;i<n;i++){
            heap[i] = ran.nextInt(n*2);
        }
    }
     
    public static void main(String[] args) {
        initData(1*10000);
        long start = System.currentTimeMillis();
        algorithm();
        //custom(heap.length);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end-start));
        show();
    }
     
    /**
     * 展示排序结果
     */
    public static void show(){
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < heap.length; j++) {
            //System.out.print(heap[j] + " ");
            //sb.append(heap[j]+" ");
        }
        //System.out.println(sb.length()+","+sb.toString());        
    }
     
    /**
     * 自己定义的排序算法，主要用来比较时间
     */
    public static void custom(int end){
        for(int i=0;i<end-1;i++){
            if(heap[i]>heap[i+1]){
                int temp = heap[i];
                heap[i] = heap[i+1];
                heap[i+1] = temp;
            }
        }
        if(end>1){
            custom(end-1);
        }
    }
     
    /**
     * 最小堆排序算法
     */
    public static void algorithm(){
        int temp;
        /*
        * 创建堆（对该堆进行简单的排序）
        */
        CreateHeap();
        for (int i = heap.length - 1; 0 < i; i--) {
            temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            /*
            //展示每次排序后的结果
            for (int j = 0; j < heap.length; j++) {
                System.out.print(heap[j] + " ");
            }
            */
            //System.out.println(i);//换行
            //从堆顶进行调整，使未排序堆中最大关键字到堆顶
            AdjustHeap(0,i);
        }
    }
    /**
    * 调整堆使其堆顶为未排序堆中最大关键字
    */
    public static void AdjustHeap(int location,int unSortlength) {
        int temp;
        int tempLoc;
        //确保左右节点存在
        if ((tempLoc = (location + 1) * 2) < unSortlength) {
            //判断左右节点大小
            if (heap[tempLoc] >= heap[tempLoc - 1]) {
                //判断父节点与子节点的大小，若父节点小，则与大的子节点换位
                if (heap[location] < heap[tempLoc]) {
                temp = heap[location];
                heap[location] = heap[tempLoc];
                heap[tempLoc] = temp;
                //递归法对换位后的子节点及其子节点进行调整
                AdjustHeap(tempLoc,unSortlength);
                }
            } else {
                //左节点大于右节点
                if (heap[location] < heap[tempLoc - 1]) {
                    temp = heap[location];
                    heap[location] = heap[tempLoc - 1];
                    heap[tempLoc - 1] = temp;
                    //递归法对换位后的子节点及其子节点进行调整
                    AdjustHeap(tempLoc - 1,unSortlength);
                }
            }
        }
        //确保左节点存在
        else if ((tempLoc = (location + 1) * 2 - 1) < unSortlength) {
            //与左节点进行比较
            if (heap[location] < heap[tempLoc]) {
                //左子节点大于父节点，将两者进行换位
                temp = heap[location];
                heap[location] = heap[tempLoc];
                heap[tempLoc] = temp;
                AdjustHeap(tempLoc,unSortlength);
            }
        }
    }
     
    /**
    * 创建堆（对该堆进行简单的排序）
    */
    public static void CreateHeap() {
        for (int i = heap.length - 1; i >= 0; i--) {
            AdjustHeap(i,heap.length);
        }
    }
 
 
}