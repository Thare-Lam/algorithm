package hackerrank.common_child;

import java.util.Scanner;

public class Solution {

    static int commonChild(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1][len2];
        int index1 = s1.indexOf(s2.charAt(0));
        int index2 = s2.indexOf(s1.charAt(0));
        int i, j;
        if (index1 >= 0) {
            for (j = index1; j < len1; ++j) {
                dp[0][j] = 1;
            }
        }
        if (index2 >= 0) {
            for (i = index2; i < len2; ++i) {
                dp[i][0] = 1;
            }
        }
        for (i = 1; i < len2; ++i) {
            for (j = 1; j < len1; ++j) {
                if (s2.charAt(i) == s1.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}
