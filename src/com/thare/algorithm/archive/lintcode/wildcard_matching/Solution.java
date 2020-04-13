package com.thare.algorithm.archive.lintcode.wildcard_matching;

public class Solution {

    /*
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray());
    }

    public boolean isMatch(char[] s, char[] p) {
        boolean[][] dp = new boolean[s.length + 1][p.length + 1];
        dp[0][0] = true;
        int i, j;
        for (j = 1; j <= p.length && dp[0][j - 1]; ++j) {
            dp[0][j] = p[j - 1] == '*';
        }
        for (i = 1; i <= s.length; ++i) {
            for (j = 1; j <= p.length; ++j) {
                if (p[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                } else if (p[j - 1] == '.' || p[j - 1] == s[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length][p.length];
    }

}
