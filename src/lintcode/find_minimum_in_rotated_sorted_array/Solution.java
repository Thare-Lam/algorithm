package lintcode.find_minimum_in_rotated_sorted_array;

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    public int recursion(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        if (nums[start] > nums[mid]) {
            return recursion(nums, start, mid);
        } else {
            if (nums[end] > nums[mid]) {
                return nums[start];
            } else {
                return recursion(nums, mid + 1, end);
            }
        }
    }
}
