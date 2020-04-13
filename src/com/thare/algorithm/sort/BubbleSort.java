package com.thare.algorithm.sort;

public class BubbleSort {

    public static void main(String[] args) {
        sort(TestUtil.INT_ARRAY_TO_BE_SORTED);
        TestUtil.printArray(TestUtil.INT_ARRAY_TO_BE_SORTED);
    }

    public static void sort(int[] array) {
        boolean noSwap = false;
        int temp;
        for (int i = array.length - 1; i > 0 && !noSwap; --i) {
            noSwap = true;
            for (int j = 0; j < i; ++j) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    noSwap = false;
                }
            }
        }
    }

}
