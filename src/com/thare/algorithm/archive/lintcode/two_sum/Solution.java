package com.thare.algorithm.archive.lintcode.two_sum;

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int i;
        int j;
        int[] result = new int[2];
        boolean flag = true;
        for (i = 0; i < numbers.length - 1 && flag; ++i) {
            for (j = i + 1; j < numbers.length; ++j) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    flag = false;
                    break;
                }
            }
        }
        return result;
    }
}
