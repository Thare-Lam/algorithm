package com.thare.algorithm.archive.company.youzan._20170921._02;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()) {
            long k = in.nextLong();
            int m = in.nextInt();
            int n = in.nextInt();
            int x = -1, y = -1;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (k == in.nextLong()) {
                        x = i;
                        y = j;
                    }
                }
            }
            System.out.println(x + " " + y);
        }
    }

}
