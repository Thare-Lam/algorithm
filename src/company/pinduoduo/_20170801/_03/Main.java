package company.pinduoduo._20180801._03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int i, j;
            int n = in.nextInt();
            int[] h = new int[n];
            for (i = 0; i < n; ++i) {
                h[i] = in.nextInt();
            }
            int m = in.nextInt();
            int[] w = new int[m];
            for (j = 0; j < m; ++j) {
                w[j] = in.nextInt();
            }
            Arrays.sort(h);
            Arrays.sort(w);
            int count = 0;
            for (i = n - 1, j = m - 1; i >= 0 && j >= 0;) {
                if (w[j] >= h[i]) {
                    ++count;
                    --i;
                    --j;
                } else {
                    --i;
                }
            }
            System.out.println(count);
        }
    }

}
