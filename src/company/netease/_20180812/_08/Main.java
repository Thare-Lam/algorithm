package company.netease._20180812._08;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(maxArrCount(n, k));
        }
    }

    private static long maxArrCount(int n, int k) {
        long[] dp = new long[k + 1];
        Arrays.fill(dp, 1L);
        int i, j, pre, cur;
        long sum, ignore;
        for (i = 1; i < n; ++i) {
            sum = 0;
            for (j = 1; j <= k; ++j) {
                sum += dp[j];
                sum %= 1000000007;
            }
            for (pre = 1; pre <= k; ++pre) {
                ignore = 0;
                for (cur = pre * 2; cur <= k; cur += pre) {
                    ignore += dp[cur];
                    ignore %= 1000000007;
                }
                dp[pre] = sum - ignore;
            }
        }
        long res = 0;
        for (j = 1; j <= k; ++j) {
            res += dp[j];
            res %= 1000000007;
        }
        return res;
    }
}
