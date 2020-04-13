package com.thare.algorithm.archive.lintcode.ugly_number_ii;

public class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        int[] base = new int[]{2, 3, 5};
        int len = base.length;
        int[] index = new int[len];
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i = 1;
        int j;
        int min;
        while (i < n) {
            min = Integer.MAX_VALUE;
            for (j = 0; j < len; j++) {
                min = Math.min(min, ugly[index[j]] * base[j]);
            }
            for (j = 0; j < len; j++) {
                if (min == ugly[index[j]] * base[j]) {
                    ++index[j];
                }
            }
            ugly[i++] = min;
        }
        return ugly[n - 1];
    }
}
