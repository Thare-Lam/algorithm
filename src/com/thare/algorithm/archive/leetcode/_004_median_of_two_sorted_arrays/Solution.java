package com.thare.algorithm.archive.leetcode._004_median_of_two_sorted_arrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mid = (len1 + len2) / 2;
        if (((len1 + len2) & 1) == 1) {
            return findMid(nums1, nums2, 0, 0, mid + 1);
        } else {
            return (double)(findMid(nums1, nums2, 0, 0, mid) + findMid(nums1, nums2, 0, 0, mid + 1)) / 2;
        }
    }

    private int findMid(int[] nums1, int[] nums2, int s1, int s2, int k) {
        if (s1 >= nums1.length) {
            return nums2[s2 + k - 1];
        }
        if (s2 >= nums2.length) {
            return nums1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        int idx1 = s1 + k / 2 - 1;
        int idx2 = s2 + k / 2 - 1;
        int v1 = idx1 < nums1.length ? nums1[idx1] : Integer.MAX_VALUE;
        int v2 = idx2 < nums2.length ? nums2[idx2] : Integer.MAX_VALUE;
        if (v1 < v2) {
            return findMid(nums1, nums2, idx1 + 1, s2, k - k / 2);
        } else {
            return findMid(nums1, nums2, s1, idx2 + 1, k - k / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(
        new Solution().findMedianSortedArrays(new int[]{2, 3, 4}, new int[]{1}));
    }

}
