package com.thare.algorithm.archive.lintcode.climbing_stairs;

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        n -= 2;
        int a = 1;
        int b = 2;
        while (n-- > 0) {
            b += a;
            a = b - a;
        }
        return b;
    }
}
