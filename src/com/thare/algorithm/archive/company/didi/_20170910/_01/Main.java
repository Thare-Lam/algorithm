package com.thare.algorithm.archive.company.didi._20170910._01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = in.nextInt();
            }
            int result = process(arr, n);
            System.out.println(result);
        }
    }

    private static int process(int[] arr, int n) {
        int[][] dp = new int[n + 1][n + 1];
        int[][] xor = new int[n + 1][n + 1];
        int i, j;
        for (i = 1; i <= n; ++i) {
            dp[i][i] = arr[i - 1] == 0 ? 1 : 0;
            xor[i][i] = arr[i - 1];
        }
        for (j = 1; j <= n - 1; ++j) {
            for (i = 1; i <= n - j; ++i) {
                dp[i][i + j] = f(arr, dp, xor, i, i + j);
            }
        }
        return dp[1][n];
    }

    private static int f(int[] arr, int[][] dp, int[][] xor, int l, int r) {
        xor[l][r] = xor[l][r - 1] ^ arr[r - 1];
        int max = xor[l][r] == 0 ? 1 : 0;
        for (int i = l; i < r; ++i) {
            max = Math.max(max, dp[l][i] + dp[i + 1][r]);
        }
        return max;
    }

}
