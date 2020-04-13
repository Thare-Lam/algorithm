package com.thare.algorithm.archive.company.netease._20170909._07;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                arr[i] = in.nextInt();
            }
            int result = process(arr, n);
            System.out.println(result);
        }
    }

    private static int process(int[] arr, int n) {
        int[][] dp = new int[1 + n][1 + n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }
        return f(dp, arr, n, 0, 0);
    }

    private static int f(int[][] dp, int[] arr, int n, int a, int b) {
        int cur = Math.max(a, b) + 1;
        if (cur > n) {
            return 0;
        }
        if (dp[a][b] != -1) {
            return dp[a][b];
        }
        return dp[a][b] = Math.min(f(dp, arr, n, cur, b) + (a > 0 ? Math.abs(arr[cur] - arr[a]) : 0),
                f(dp, arr, n, a, cur) + (b > 0 ? Math.abs(arr[cur] - arr[b]) : 0));
    }

}
