package lintcode.kth_largest_element;

public class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        int x;
        int start = 0;
        int end = nums.length - 1;
        k = nums.length - k;
        for (;;) {
            x = findK(nums, start, end);
            if (x < k) {
                start = ++x;
            } else if (x == k) {
                return nums[k];
            } else {
                end = --x;
            }
        }
    }

    private int findK(int[] nums, int start, int end) {
        int i;
        int j = start - 1;
        int midValue = nums[end];
        for (i = start; i < end; i++) {
            if (nums[i] < midValue) {
                swap(nums, ++j, i);
            }
        }
        swap(nums, ++j, end);
        return j;
    }

    private void swap(int[] nums, int a, int b) {
        if (a != b) {
            nums[a] += nums[b];
            nums[b] = nums[a] - nums[b];
            nums[a] -= nums[b];
        }
    }
}
