package lintcode.reorder_array_to_construct_the_minimum_number;

public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        boolean zeroFlag = true;
        for (int i : nums) {
            if (zeroFlag && i == 0) {
                continue;
            } else {
                zeroFlag = false;
                sb.append(i);
            }
        }
        String result = sb.toString();
        if (result.equals("")) {
            return "0";
        }
        return result;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = fun(nums, start, end);
        quickSort(nums, start, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    private int fun(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int i;
        int j = start - 1;
        int midValue = nums[end];
        for (i = start; i < end; i++) {
            if (isSmaller(nums[i], midValue)) {
                swap(nums, ++j, i);
            }
        }
        swap(nums, ++j, end);
        return j;
    }

    private boolean isSmaller(int a, int b) {
        StringBuilder sba = new StringBuilder();
        sba.append(a).append(b);
        StringBuilder sbb = new StringBuilder();
        sbb.append(b).append(a);
        return sba.toString().compareTo(sbb.toString()) < 0;
    }

    private void swap(int[] nums, int a, int b) {
        if (a != b) {
            nums[a] += nums[b];
            nums[b] = nums[a] - nums[b];
            nums[a] -= nums[b];
        }
    }

    public static void main(String[] args) {
        new Solution().minNumber(new int[]{3577,9155,9352,7911,1622});
    }
}
