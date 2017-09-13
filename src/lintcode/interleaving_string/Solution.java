package lintcode.interleaving_string;

public class Solution {
    /*
    * @param s1: A string
    * @param s2: A string
    * @param s3: A string
    * @return: Determine whether s3 is formed by interleaving of s1 and s2
    */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        if (len1 == 0 || len2 == 0) {
            return s1.equals(s3) || s2.equals(s3);
        }
        int i, j, k;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (i = 1; i <= len1 && s1.charAt(i - 1) == s3.charAt(i - 1); ++i) {
            dp[i][0] = true;
        }
        for (j = 1; j <= len2 && s2.charAt(j - 1) == s3.charAt(j - 1); ++j) {
            dp[0][j] = true;
        }
        for (k = 2; k <= len3; ++k) {
            i = k <= len2 ? 1 : k - len2;
            j = k - i;
            while (i <= len1 && j > 0) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k - 1));
                ++i;
                --j;
            }
        }
        return dp[len1][len2];
    }

}
