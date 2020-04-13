package com.thare.algorithm.archive.lintcode.reverse_integer;

public class Solution {

    /*
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        int s = 1;
        if (n < 0) {
            n = -n;
            s = -s;
        }
        long r = 0;
        while (n > 0) {
            r = r * 10 + n % 10;
            n /= 10;
        }
        r *= s;
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)r;
    }

}
