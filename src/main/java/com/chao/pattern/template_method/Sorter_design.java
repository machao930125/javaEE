package com.chao.pattern.template_method;

/**
 * Created by machao on 2018/3/13.
 */
public class Sorter_design extends Sorter_template<int[]> {
    private int[] array;

    protected void setArray(int[] array) {
        this.array=array;
    }

    protected int getLength() {
        return this.array.length;
    }

    protected boolean needSwap(int index) {
        return array[index]<array[index + 1];
    }

    protected void swap(int index) {
        int stmp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = stmp;
    }
}
