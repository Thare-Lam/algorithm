package com.thare.algorithm.archive.company.xiaohongshu._20170928._02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            char[] str = in.next().toCharArray();
            int k = in.nextInt();
            process(str, k);
        }
    }

    private static void process(char[] str, int k) {
        for (int i = 0, len = str.length; i < len; i += 2 * k) {
            reverse(str, i, i + k - 1);
        }
        System.out.println(String.valueOf(str));
    }

    private static void reverse(char[] str, int s, int k) {
        int e = k;
        if (k > str.length - 1) {
            e = str.length - 1;
        }
        reverse2(str, s, e);
    }

    private static void reverse2(char[] str, int s, int e) {
        int i = s, j = e;
        char t;
        while (i < j) {
            t = str[i];
            str[i] = str[j];
            str[j] = t;
            ++i;
            --j;
        }
    }

}
