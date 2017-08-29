package lintcode.maximum_subarray;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int a : nums) {
            sum += a;
            max = max > sum ? max : sum;
            sum = sum > 0 ? sum : 0;
        }
        return max;
    }
}
