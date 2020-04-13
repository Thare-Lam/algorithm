package com.thare.algorithm.archive.classic.get_prime;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] prime = process(20);
        System.out.println(Arrays.toString(prime));
    }

    private static int[] process(int n) {
        int i, j;
        int[] check = new int[n + 1];
        Arrays.fill(check, 1);
        check[0] = check[1] = 0;
        ArrayList<Integer> prime = new ArrayList<>();
        for (i = 2; i <= n; ++i) {
            if (check[i] == 1) {
                prime.add(i);
            }
            for (j = 0; j < prime.size() && i * prime.get(j) <= n; ++j) {
                check[i * prime.get(j)] = 0;
            }
        }
        int[] res = new int[prime.size()];
        for (i = 0; i < res.length; ++i) {
            res[i] = prime.get(i);
        }
        return res;
    }
}
