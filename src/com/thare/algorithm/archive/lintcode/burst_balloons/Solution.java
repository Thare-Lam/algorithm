package com.thare.algorithm.archive.lintcode.burst_balloons;

public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] nnums = new int[len + 2];
        int[][] visited = new int[len + 2][len + 2];
        int[][] result = new int[len + 2][len + 2];
        nnums[0] = 1;
        nnums[len + 1] = 1;
        for (int i = 0; i < len; i++) {
            nnums[i + 1] = nums[i];
        }
        return recursion(nnums, visited, result, 1, len);
    }

    private int recursion(int[] nums, int[][] visited, int[][] result, int start, int end) {
        if (visited[start][end] == 1) {
            return result[start][end];
        }
        int max = 0;
        for (int i = start; i <= end; i++) {
            int mid = nums[start - 1] * nums[i] * nums[end + 1];
            int left = recursion(nums, visited, result, start, i - 1);
            int right = recursion(nums, visited, result, i + 1, end);
            max = Math.max(max, left + mid + right);
        }
        visited[start][end] = 1;
        result[start][end] = max;
        return max;
    }

}

