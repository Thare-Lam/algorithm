package company.netease._20170812._06;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            int[] res = new int[n];
            int i, j, k, index, sum;
            for (i = 0; i < n; ++i) {
                x[i] = in.nextInt();
            }
            for (j = 0; j < n; ++j) {
                y[j] = in.nextInt();
            }
            for (i = 0; i < n; ++i) {
                res[i] = Integer.MAX_VALUE;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (i = 0; i < n; ++i) {
                for (j = 0; j < n; ++j) {
                    for (k = 0; k < n; ++k) {
                        pq.add(Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]));
                    }
                    index = 0;
                    sum = 0;
                    while (!pq.isEmpty()) {
                        sum += pq.poll();
                        res[index] = Math.min(res[index], sum);
                        ++index;
                    }
                }
            }
            for(i = 0; i < n; ++i) {
                System.out.print(res[i] + (i == n - 1 ? "\n" : " "));
            }
        }
    }

}
