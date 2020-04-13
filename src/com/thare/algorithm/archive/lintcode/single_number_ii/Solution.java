package com.thare.algorithm.archive.lintcode.single_number_ii;

public class Solution {
    /**
     * @param a : An integer array
     * @return : An integer
     */
    public int singleNumberII(int[] a) {
        int result = 0;
        int x;
        for (int i = 0; i < 32; i++) {
            x = 0;
            for (int j = 0; j < a.length; j++) {
                x += a[j] >> i & 1;
                x %= 3;
            }
            result |= (x << i);
        }
        return result;
    }
}
