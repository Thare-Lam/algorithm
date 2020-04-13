package com.thare.algorithm.archive.lintcode.single_number;

public class Solution {
    /**
     *@param nums : an integer array
     *return : a integer
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
}
