package com.thare.algorithm.archive.nowcoder.test2017._661c49118ca241909add3a11c96408c8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                arr[i] = in.nextInt();
            }
            int k = in.nextInt();
            int d = in.nextInt();
            long[][][] dp = new long[n + 1][k + 1][2];
            long res = Long.MIN_VALUE;
            int i, j, x;
            for (i = 1; i <= n; ++i) {
                dp[i][1][0] = dp[i][1][1] = arr[i];
                for (j = 2; j <= k; ++j) {
                    for (x = i - 1; x >= Math.max(i - d, 1); --x) {
                        dp[i][j][0] = Math.max(dp[i][j][0], Math.max(dp[x][j - 1][0] * arr[i], dp[x][j - 1][1] * arr[i]));
                        dp[i][j][1] = Math.min(dp[i][j][1], Math.min(dp[x][j - 1][0] * arr[i], dp[x][j - 1][1] * arr[i]));
                    }
                }
                res = Math.max(res, dp[i][k][0]);
            }
            System.out.println(res);
        }
    }
}
