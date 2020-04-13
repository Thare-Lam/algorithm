package com.thare.algorithm.archive.lintcode.partition_array_by_odd_and_even;

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if ((nums[i] & 1) == 0) {
                nums[j] += nums[i];
                nums[i] = nums[j] - nums[i];
                nums[j] -= nums[i];
                j--;
            } else {
                i++;
            }
        }
    }
}
