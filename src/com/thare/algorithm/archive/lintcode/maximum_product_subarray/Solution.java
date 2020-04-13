package com.thare.algorithm.archive.lintcode.maximum_product_subarray;

public class Solution {
    /*
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j;
        while (i < len) {
            while (i < len && nums[i] == 0) {
                ++i;
            }
            if (i == len) {
                break;
            }
            j = i + 1;
            while (j < len && nums[j] != 0) {
                ++j;
            }
            if (j == len) {
                max = Math.max(max, findMax(nums, i, len - 1));
                break;
            }
            max = Math.max(max, findMax(nums, i, j - 1));
            i = j + 1;
        }
        return max;
    }

    private int findMax(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int first = -1;
        int last = -1;
        int countNegative = 0;
        for (int i = start; i <= end; ++i) {
            if (nums[i] < 0) {
                if (first == -1) {
                    first = i;
                } else {
                    last = i;
                }
                ++countNegative;
            }
        }
        if ((countNegative & 1) == 0) {
            return cal(nums, start, end);
        } else {
            if (last == -1) {
                return Math.max(cal(nums, start, first - 1), cal(nums, first + 1, end));
            } else {
                if (cal(nums, start, first) <= cal(nums, last, end)) {
                    return cal(nums, start, last - 1);
                } else {
                    return cal(nums, first + 1, end);
                }
            }
        }
    }

    private int cal(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        int res = 1;
        for (int i = start; i <= end; ++i) {
            res *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{0,-1,4,-4,5,-2,-1,-1,-2,-3,0,-3,0,1,-1,-4,4,6,2,3,0,-5,2,1,-4,-2,-1,3,-4,-6,0,2,2,-1,-5,1,1,5,-6,2,1,-3,-6,-6,-3,4,0,-2,0,2}));
    }
}
