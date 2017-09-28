package leetcode._679_24_game;

public class Solution {

    public boolean judgePoint24(int[] nums) {
        double[] nums2 = new double[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            nums2[i] = nums[i];
        }
        return process(nums2);
    }

    private boolean process(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(24.0 - nums[0]) <= 0.00001;
        }
        double[] newNums;
        boolean result;
        for (int i = 0, len = nums.length; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                for (int k = 1; k <= 6; ++k) {
                    if ((k == 4 && nums[j] == 0) || (k == 6 && nums[i] == 0)) {
                        continue;
                    }
                    newNums = genNewNums(nums, i, j, k);
                    result = process(newNums);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private double[] genNewNums(double[] nums, int i, int j, int k) {
        double[] newNums = new double[nums.length - 1];
        int index = 0;
        for (int x = 0; x < nums.length; ++x) {
            if (x == i) {
                continue;
            }
            if (x == j) {
                newNums[index++] = opt(nums[i], nums[j], k);
            } else {
                newNums[index++] = nums[x];
            }
        }
        return newNums;
    }

    private double opt(double a, double b, int k) {
        switch (k) {
            case 1:
                return a + b;
            case 2:
                return a - b;
            case 3:
                return a * b;
            case 4:
                return a / b;
            case 5:
                return b - a;
            case 6:
                return b / a;
        }
        return 0;
    }

}
