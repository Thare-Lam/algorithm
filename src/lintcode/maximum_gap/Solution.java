package lintcode.maximum_gap;

import java.util.Arrays;

public class Solution {
    /*
     * @param nums: an array of integers
     * @return: the maximun difference
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int last = nums[0];
        int gap = 0;
        int k;
        for (int i = 1;i < nums.length; ++i) {
            k = nums[i] - last;
            if (k > gap) {
                gap = k;
            }
            last = nums[i];
        }
        return gap;
    }
}
