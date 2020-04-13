package com.thare.algorithm.archive.lintcode.maximum_subarray_iii;

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        int len = nums.length;
        int[][][] result = new int[len][len][k + 1];
        byte[][][] visited = new byte[len][len][k + 1];
        return recursion(nums, result, visited, 0, len - 1, k);
    }

    private int recursion(int[] nums, int[][][] result, byte[][][] visited, int start, int end, int k) {
        if (visited[start][end][k] == 1) {
            return result[start][end][k];
        }
        if (k == 1) {
            visited[start][end][k] = 1;
            result[start][end][k] = maxSubArray(nums, start, end);
            return result[start][end][k];
        }
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end + 1 - k; i++) {
            max = Math.max(max, maxSubArray(nums, start, i) + recursion(nums, result, visited, i + 1, end, k - 1));
        }
        visited[start][end][k] = 1;
        result[start][end][k] = max;
        return max;
    }

    private int maxSubArray(int[] nums, int start, int end) {
        int max = nums[start];
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
            max = max > sum ? max : sum;
            sum = sum > 0 ? sum : 0;
        }
        return max;
    }

}
