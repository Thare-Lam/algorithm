package leetcode._005_longest_palindromic_substring;

public class Solution {

    private int start;

    private int max;

    public String longestPalindrome(String s) {
        for (int i = 0, len = s.length(); i < len; ++i) {
            f(s, i, i);
            f(s, i, i + 1);
        }
        return s.substring(start, start + max);
    }

    private void f(String s, int l, int r) {
        int len = s.length();
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }
        if (r - l - 1 > max) {
            max = r - l - 1;
            start = l + 1;
        }
    }

}
