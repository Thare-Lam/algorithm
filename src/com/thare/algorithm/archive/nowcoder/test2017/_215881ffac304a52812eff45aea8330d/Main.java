package com.thare.algorithm.archive.nowcoder.test2017._215881ffac304a52812eff45aea8330d;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            String result = process(n);
            System.out.println(result);
        }
    }

    private static String process(int n) {
        int count = 0;
        for (int i = 2; i <= n - 1; ++i) {
            count += countEver(n, i);
        }
        return div(count, n - 2);
    }

    private static int countEver(int n, int k) {
        int count = 0;
        while (n > 0) {
            count += n % k;
            n /= k;
        }
        return count;
    }

    private static String div(int count, int k) {
        if (count % k == 0) {
            return String.format("%d/%d", count / k, 1);
        } else {
            int d = 2;
            while (d < k) {
                if (count % d == 0 && k % d == 0) {
                    count /= d;
                    k /= d;
                } else {
                    ++d;
                }
            }
            return String.format("%d/%d", count, k);
        }
    }

}


