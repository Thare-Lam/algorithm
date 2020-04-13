package com.thare.algorithm.archive.lintcode.recover_rotated_sorted_array;

import java.util.List;

public class Solution {
    /*
     * @param nums: An integer
     * @return:
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        int mid = findMid(nums);
        if (mid < 0) {
            return;
        }
        rotate(nums, 0, mid);
        rotate(nums, mid + 1, nums.size() - 1);
        rotate(nums, 0, nums.size() - 1);
    }

    private int findMid(List<Integer> nums) {
        for (int i = nums.size() - 1; i > 0; --i) {
            if (nums.get(i) < nums.get(i - 1)) {
                return i - 1;
            }
        }
        return -1;
    }

    private void rotate(List<Integer> nums, int start, int end) {
        int temp;
        for (int i = start, j = end; i < j; ++i, --j) {
            temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
}
