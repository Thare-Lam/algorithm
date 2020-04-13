package com.thare.algorithm.archive.lintcode.fibonacci;

public class Solution {
    /*
     * @param : an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        if (n <= 2) {
            return n - 1;
        }
        n -= 2;
        int x = 0;
        int y = 1;
        while (n-- > 0) {
            y += x;
            x = y - x;
        }
        return y;
    }
}
