package com.thare.algorithm.archive.lintcode.majority_number_ii;

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int a = 0;
        int b = 0;
        int ca = 0;
        int cb = 0;
        for (int i : nums) {
            if (i == a) {
                ++ca;
            } else if (i == b) {
                ++cb;
            } else if (ca == 0) {
                a = i;
                ca = 1;
            } else if (cb == 0) {
                b = i;
                cb = 1;
            } else {
                --ca;
                --cb;
            }
        }
        ca = 0;
        cb = 0;
        for (int i : nums) {
            if (i == a) {
                ++ca;
            } else if (i == b) {
                ++cb;
            }
        }
        return ca > cb ? a : b;
    }

}
