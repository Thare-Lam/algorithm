package com.thare.algorithm.archive.lintcode.house_robber;

public class Solution {
    /*
     * @param a : An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] a) {
        int len = a.length;
        if (len == 0) {
            return 0;
        }
        int x = 0;
        int y = 1;
        long[] store = new long[2];
        store[1] = a[0];
        for (int i = 1; i < len; ++i) {
            x += y;
            y = x - y;
            x -= y;
            store[y] = Math.max(store[y] + a[i], store[x]);
        }
        return Math.max(store[0], store[1]);
    }
}
