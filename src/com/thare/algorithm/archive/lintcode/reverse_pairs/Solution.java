package com.thare.algorithm.archive.lintcode.reverse_pairs;

public class Solution {
    /**
     * @param a an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] a) {
        return recursion(a, 0, a.length - 1);
    }

    private int recursion(int[] a, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (start + 1 == end) {
            if (a[start] > a[end]) {
                a[start] += a[end];
                a[end] = a[start] - a[end];
                a[start] -= a[end];
                return 1;
            }
            return 0;
        }
        int mid = (start + end) / 2;
        int left = recursion(a, start, mid);
        int right = recursion(a, mid + 1, end);
        int leftAndRight = count(a, start, mid, mid + 1, end);
        return left + right + leftAndRight;
    }

    private int count(int[] a, int startA, int endA, int startB, int endB) {
        int i = startA;
        int j = startB;
        int count = 0;
        int temp = 0;
        while (i <= endA && j <= endB) {
            if (a[i] > a[j]) {
                ++temp;
                ++j;
            } else {
                count += temp * (endA - i + 1);
                temp = 0;
                ++i;
            }
        }
        if (i <= endA) {
            count += temp * (endA - i + 1);
        }
        int[] sorted = sort(a, startA, endA, startB, endB);
        i = startA;
        j = 0;
        while (j < sorted.length) {
            a[i++] = sorted[j++];
        }
        return count;
    }

    private int[] sort(int[] a, int startA, int endA, int startB, int endB) {
        int[] b = new int[endB - startA + 1];
        int i = startA;
        int j = startB;
        int k = 0;
        while (i <= endA && j <= endB) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        while (i <= endA) {
            b[k++] = a[i++];
        }
        while (j <= endB) {
            b[k++] = a[j++];
        }
        return b;
    }
}
