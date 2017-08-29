package nowcoder.Test2017.d2cced737eb54a3aa550f53bb3cc19d0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] desk = new int[n];
            long[] dp = new long[n + 1];
            int[][] group = new int[m][2];
            int i, j;
            for (j = 0; j < n; ++j) {
                desk[j] = scanner.nextInt();
            }
            for (i = 0; i < m; ++i) {
                group[i][0] = scanner.nextInt();
                group[i][1] = scanner.nextInt();
            }
            Arrays.sort(desk);
            Arrays.sort(group, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
                }
            });

            for (i = 0; i < m; ++i) {
                for (j = n; j >= n - 1; --j) {
                    if (desk[j - 1] >= group[i][0]) {
                        dp[j] = Math.max(dp[j], dp[j - 1] + group[i][1]);
                    }
                }
            }

            System.out.println(dp[n]);
        }
    }

}
