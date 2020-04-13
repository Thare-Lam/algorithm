package com.thare.algorithm.archive.lintcode.a_b_problem;

public class Solution {
    /*
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        int xor;
        while (b != 0) {
            xor = a ^ b;
            b = (a & b) << 1;
            a = xor;
        }
        return a;
    }
}
