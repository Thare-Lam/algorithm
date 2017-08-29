package lintcode.maximum_subarray_ii;

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        for (int i = 0; i < size - 1; i++) {
            max = Math.max(max, maxSubArray(nums, 0, i) + maxSubArray(nums, i + 1, size - 1));
        }
        return max;
    }

    private int maxSubArray(ArrayList<Integer> nums, int start, int end) {
        int max = nums.get(start);
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums.get(i);
            max = max > sum ? max : sum;
            sum = sum > 0 ? sum : 0;
        }
        return max;
    }
}
