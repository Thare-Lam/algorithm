package com.thare.algorithm.sort;

public class SelectSort {

    public static void main(String[] args) {
        sort(TestUtil.INT_ARRAY_TO_BE_SORTED);
        TestUtil.printArray(TestUtil.INT_ARRAY_TO_BE_SORTED);
    }

    public static void sort(int[] array) {
        int x, temp;
        for (int i = array.length - 1; i > 0; --i) {
            x = 0;
            for (int j = 1; j <= i; ++j) {
                x = array[x] < array[j] ? j : x;
            }
            temp = array[x];
            array[x] = array[i];
            array[i] = temp;
        }
    }

}
