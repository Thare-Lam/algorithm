package com.thare.algorithm.sort;

public class MergeSort {

    public static void main(String[] args) {
        sort(TestUtil.INT_ARRAY_TO_BE_SORTED);
        TestUtil.printArray(TestUtil.INT_ARRAY_TO_BE_SORTED);
    }

    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + ((r - l) >> 1);
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    private static void merge(int[] nums, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, x = 0;
        while (i <= m && j <= r) {
            temp[x++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= m) {
            temp[x++] = nums[i++];
        }
        while (j <= r) {
            temp[x++] = nums[j++];
        }
        for (x = 0; x < temp.length; ++x) {
            nums[l + x] = temp[x];
        }
    }
}
