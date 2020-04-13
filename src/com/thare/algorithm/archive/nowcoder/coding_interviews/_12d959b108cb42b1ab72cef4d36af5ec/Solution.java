package com.thare.algorithm.archive.nowcoder.coding_interviews._12d959b108cb42b1ab72cef4d36af5ec;

public class Solution {

    public String LeftRotateString(String str, int n) {
        if (str.length() == 0) {
            return str;
        }
        char[] s = str.toCharArray();
        n %= s.length;
        reverse(s, 0, n - 1);
        reverse(s, n, s.length - 1);
        reverse(s, 0, s.length - 1);
        return String.valueOf(s);
    }

    private void reverse(char[] s, int start, int end) {
        char c;
        for (int i = start, j = end; i < j; ++i, --j) {
            c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }

}
