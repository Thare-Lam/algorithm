package com.thare.algorithm.archive.nowcoder.test2017._7f24eb7266ce4b0792ce8721d6259800;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = scanner.nextInt();
            }
            long result = process(arr, n, sum);
            System.out.println(result);
        }
    }

    private static long process(int[] arr, int n, int sum) {
        long[][] dp = new long[n][sum + 1];
        int i, j;
        for (i = 0; i < n; ++i) {
            dp[i][0] = 1;
        }
        if (arr[0] <= sum) {
            dp[0][arr[0]] = 1;
        }
        for (i = 1; i < n; ++i) {
            for (j = 1; j <= sum; ++j) {
                dp[i][j] = dp[i-1][j];
                if (j - arr[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - arr[i]];
                }
            }
        }
        return dp[n-1][sum];
    }
}
