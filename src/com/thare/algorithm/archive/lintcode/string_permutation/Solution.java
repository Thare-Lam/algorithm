package com.thare.algorithm.archive.lintcode.string_permutation;

public class Solution {
    /*
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String a, String b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.length() != b.length()) {
            return false;
        }
        int[] store = new int[Character.MAX_VALUE];
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        for (char c : ca) {
            store[c]++;
        }
        for (char c : cb) {
            store[c]--;
            if (store[c] < 0) {
                return false;
            }
        }
        for (int i : store) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
