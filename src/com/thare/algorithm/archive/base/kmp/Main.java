package com.thare.algorithm.archive.base.kmp;

import com.thare.algorithm.archive.utils.TestUtils;

public class Main {

    public static int kmp(String a, String b) {
        return kmp(a.toCharArray(), b.toCharArray());
    }

    public static int kmp(char[] a, char[] b) {
        int lenB = b.length;
        int[] next = calNext(b);
        int k = -1;
        for (int i = 0; i < a.length; ++i) {
            while (k > -1 && b[k + 1] != a[i]) {
                k = next[k];
            }
            if (b[k + 1] == a[i]) {
                ++k;
            }
            if (k == lenB - 1) {
                return i - k;
            }
        }
        return -1;
    }

    private static int[] calNext(char[] s) {
        int len = s.length;
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < len; ++i) {
            while (k > -1 && s[k + 1] != s[i]) {
                k = next[k];
            }
            if (s[k + 1] == s[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (String[] sa : TestUtils.SUB_STRING_ARRAY) {
            if (sa[0].indexOf(sa[1]) != kmp(sa[0], sa[1])) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

}
