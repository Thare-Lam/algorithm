package com.thare.algorithm.archive.lintcode.house_robber_ii;

public class Solution {
    /**
     * @param a: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] a) {
        int len = a.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return a[0];
        }
        return Math.max(houseRobber(a, 0, len - 2), houseRobber(a, 1, len - 1));
    }

    private int houseRobber(int[] a, int start, int end) {
        int x = 0;
        int y = 1;
        int[] store = new int[2];
        store[1] = a[start];
        for (int i = start + 1; i <= end; ++i) {
            x += y;
            y = x - y;
            x -= y;
            store[y] = Math.max(store[y] + a[i], store[x]);
        }
        return Math.max(store[0], store[1]);
    }
}
