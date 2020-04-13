package com.thare.algorithm.archive.lintcode.digit_counts;

public class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        if (k > n) {
            return 0;
        }
        int count = 1;
        int temp;
        for (int i = k + 1; i <= n; i++) {
            temp = i;
            while (temp > 0) {
                if (temp % 10 == k) {
                    ++count;
                }
                temp /= 10;
            }
        }
        return count;
    }


}
