package company.xiaohongshu._20170928._03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
                b[i] = in.nextInt();
            }
            int result = process(a, b, n, 0, p, Integer.MAX_VALUE);
            System.out.println(result);
        }
    }

    private static int process(int[] a, int[] b, int n, int s, int rest, int min) {
        if (s == n) {
            return rest;
        }
        for (int i = 0; i <= b[s]; ++i) {
            if (a[s] * i > rest) {
                break;
            }
            min = Math.min(min, process(a, b, n, s + 1, rest - a[s] * i, min));
        }
        return min;
    }

}
