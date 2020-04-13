package com.thare.algorithm.archive.base.binary_search;

import com.thare.algorithm.archive.utils.TestUtils;

public class Main {

    public static int binarySearch(int arr[], int k) {
        return binarySearch(arr, 0, arr.length, k);
    }

    public static int binarySearch(int arr[], int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if (arr[mid] < k) {
            return binarySearch(arr, mid + 1, end, k);
        } else if (arr[mid] > k) {
            return binarySearch(arr, start, mid - 1, k);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = TestUtils.SEARCH_ARRAY_INT;
        boolean flag = true;
        for (int i = 0; i < arr.length; ++i) {
            if (binarySearch(arr, arr[i]) != i) {
                flag = false;
            }
        }
        System.out.println(flag);
    }

}
