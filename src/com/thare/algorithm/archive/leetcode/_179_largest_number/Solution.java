package com.thare.algorithm.archive.leetcode._179_largest_number;

public class Solution {

    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        if (isAllZero(nums)) {
            return "0";
        }
        quickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < 0 || start >= end) {
            return;
        }
        int mid = getP(arr, start, end);
        quickSort(arr, start, mid - 1);
        quickSort(arr, mid + 1, end);
    }

    private int getP(int[] arr, int start, int end) {
        int i, k = start - 1;
        int pn = arr[end];
        for (i = start; i < end; ++i) {
            if (!isSmall(arr[i], pn)) {
                swap(arr, ++k, i);
            }
        }
        swap(arr, ++k, end);
        return k;
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private boolean isSmall(int a, int b) {
        return (a + "" + b).compareTo(b + "" + a) < 0;
    }

    private boolean isAllZero(int[] nums) {
        for (int num: nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

}
