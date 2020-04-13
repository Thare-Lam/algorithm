package com.thare.algorithm.archive.lintcode.find_minimum_in_rotated_sorted_array_ii;

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        return recursion(num, 0, num.length - 1);
    }

    public int recursion(int[] num, int start, int end) {
        if (start == end) {
            return num[start];
        }
        int mid = (start + end) / 2;
        if (num[start] > num[mid]) {
            return recursion(num, start + 1, mid);
        } else if (num[start] == num[mid]) {
            if (num[end] > num[mid]) {
                return num[start];
            } else if (num[end] == mid) {
                return traverse(num, start, end);
            } else {
                return recursion(num, mid + 1, end);
            }
        } else {
            if (num[end] >= num[mid]) {
                return num[start];
            } else {
                return recursion(num, mid + 1, end);
            }
        }
    }

    private int traverse(int[] num, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, num[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{4,4,5,5,6,6,7,7,0,0,1,1,2,2}));
    }
}
