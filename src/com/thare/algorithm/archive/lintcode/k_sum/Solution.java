package com.thare.algorithm.archive.lintcode.k_sum;

public class Solution {

    /*
     * @param A: An integer array
     * @param k: A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum(int[] A, int k, int target) {
        int n = A.length;
        if (k > n) {
            return 0;
        }
        int[][][] dp = new int[k + 1][n + 1][target + 1];
        int i, j, x;
        for (i = 0; i <= n; ++i) {
            dp[0][i][0] = 1;
        }
        for (x = 1; x <= k; ++x) {
            for (i = 1; i <= n; ++i) {
                for (j = 1; j <= target; ++j) {
                    dp[x][i][j] = dp[x][i - 1][j];
                    if (j >= A[i - 1]) {
                        dp[x][i][j] += dp[x - 1][i - 1][j - A[i - 1]];
                    }
                }
            }
        }
        return dp[k][n][target];
    }

}
