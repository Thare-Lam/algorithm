package com.thare.algorithm.archive.base.insertion_sort;

import com.thare.algorithm.archive.utils.TestUtils;

public class Main {

    private static void insertionSort(int[] arr) {
        int i, j, current;
        for (i = 1; i < arr.length; ++i) {
            current = arr[i];
            for (j = i - 1; j >= 0; --j) {
                if (arr[j] > current) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = TestUtils.SORT_ARRAY_INT;
        insertionSort(arr);
        TestUtils.printArray(arr);
    }

}
