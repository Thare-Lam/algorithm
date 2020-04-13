package com.thare.algorithm.sort;

public class InsertSort {

    public static void main(String[] args) {
        sort(TestUtil.INT_ARRAY_TO_BE_SORTED);
        TestUtil.printArray(TestUtil.INT_ARRAY_TO_BE_SORTED);
    }

    public static void sort(int[] array) {
        int current, j;
        for (int i = 1; i < array.length; ++i) {
            current = array[i];
            for (j = i - 1; j >= 0 && array[j] > current; --j) {
                array[j + 1] = array[j];
            }
            array[j + 1] = current;
        }
    }

}
