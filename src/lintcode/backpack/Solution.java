package lintcode.backpack;

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        int i, j;
        for (i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }
        for (i = 1; i <= n; ++i) {
            for (j = 1; j <= m; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (dp[i][j] == 0 && j >= A[i - 1]) {
                    dp[i][j] = dp[i - 1][j - A[i - 1]];
                }
            }
        }
        for (j = m; j >= 0; --j) {
            if (dp[n][j] == 1) {
                return j;
            }
        }
        return 0;
    }
}
