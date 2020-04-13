package com.thare.algorithm.archive.company.netease._20170909._05;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n, input, k;
        boolean flag;
        while (t-- > 0) {
            n = in.nextInt();
            k = 0;
            flag = false;
            while (n-- > 0) {
                input = in.nextInt();
                if ((input & 1) == 1) {
                    --k;
                } else if ((input % 4) == 0) {
                    ++k;
                } else {
                    flag = true;
                }
            }
            if (!flag) {
                ++k;
            }
            System.out.println(k >= 0 ? "Yes" : "No");
        }
    }

}
