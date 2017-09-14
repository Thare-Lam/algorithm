package leetcode._053_maximum_subarray;

public class Solution {

    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            if (sum > max) {
                max = sum;
            }
            sum = sum < 0 ? 0 : sum;
        }
        return max;
    }

}