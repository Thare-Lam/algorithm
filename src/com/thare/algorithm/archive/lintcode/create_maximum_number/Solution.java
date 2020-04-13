package com.thare.algorithm.archive.lintcode.create_maximum_number;

import java.util.*;

public class Solution {

    /*
     * @param nums1: an integer array of length m with digits 0-9
     * @param nums2: an integer array of length n with digits 0-9
     * @param k: an integer and k <= m + n
     * @return: an integer array
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int start = 0;
        if (k > nums2.length) {
            start = k - nums2.length;
        }
        int[] max = new int[k];
        Arrays.fill(max, -1);
        for (int i = start; i <= Math.min(nums1.length, k); ++i) {
            int[] pn1 = pick(nums1, i);
            int[] pn2 = pick(nums2, k - i);
            int[] nk = merge(pn1, pn2);
            if (compare(nk, 0, max, 0) > 0) {
                max = nk;
            }
        }
        return max;
    }

    private int[] pick(int[] nums, int k) {
        return remove(nums, nums.length - k);
    }


    private static int[] remove(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int i = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        while (k > 0 && i < nums.length) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < nums[i]) {
                stack.pop();
                --k;
            }
            stack.push(nums[i]);
            ++i;
        }
        while (k-- > 0) {
            stack.pop();
        }
        while (i < nums.length) {
            stack.add(nums[i++]);
        }
        int[] res = new int[stack.size()];
        int idx = 0;
        for (int a : stack) {
            res[idx++] = a;
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int idx = 0, idx1 = 0, idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] > nums2[idx2]) {
                res[idx++] = nums1[idx1++];
            } else if (nums1[idx1] < nums2[idx2]) {
                res[idx++] = nums2[idx2++];
            } else {
                if (compare(nums1, idx1, nums2, idx2) > 0) {
                    res[idx++] = nums1[idx1++];
                } else {
                    res[idx++] = nums2[idx2++];
                }
            }
        }
        while (idx1 < nums1.length) {
            res[idx++] = nums1[idx1++];
        }
        while (idx2 < nums2.length) {
            res[idx++] = nums2[idx2++];
        }
        return res;
    }

    private int compare(int[] nums1, int s1, int[] nums2, int s2) {
        int i = s1;
        int j = s2;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ++i;
                ++j;
            } else {
                return nums1[i] - nums2[j];
            }
        }
        if (i == nums1.length && j == nums2.length){
            return 1;
        } else if (i == nums1.length) {
            return compare(nums1, s1, nums2, j);
        } else {
            return compare(nums1, i, nums2, s2);
        }
    }

}
