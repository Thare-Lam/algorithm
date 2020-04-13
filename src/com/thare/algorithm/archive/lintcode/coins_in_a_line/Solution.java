package com.thare.algorithm.archive.lintcode.coins_in_a_line;

public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        return n % 3 > 0;
    }
}
