package com.thare.algorithm.sort;

public class QuickSort {

    public static void main(String[] args) {
        sort(TestUtil.INT_ARRAY_TO_BE_SORTED);
        TestUtil.printArray(TestUtil.INT_ARRAY_TO_BE_SORTED);
    }

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = getP(array, start, end);
        //int p = getP2(array, start, end);
        quickSort(array, start, p - 1);
        quickSort(array, p + 1, end);
    }

    private static int getP(int[] array, int start, int end) {
        int k = start - 1;
        for (int i = start; i < end; ++i) {
            if (array[i] < array[end]) {
                swap(array, ++k, i);
            }
        }
        swap(array, ++k, end);
        return k;
    }

    private static int getP2(int[] array, int start, int end) {
        int i = start, j = end;
        int pValue = array[start];
        while (i < j) {
            while (i < j && array[j] >= pValue) {
                --j;
            }
            if (i < j) {
                array[i++] = array[j];
            }
            while (i < j && array[i] <= pValue) {
                ++i;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = pValue;
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
