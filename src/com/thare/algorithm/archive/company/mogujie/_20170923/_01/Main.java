package com.thare.algorithm.archive.company.mogujie._20170923._01;

import java.util.Scanner;

public class Main {

    private static int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            days[2] = 28;
            int year = Integer.valueOf(in.next());
            int month = Integer.valueOf(in.next());
            int day = Integer.valueOf(in.next());
            if (isR(year)) {
                days[2] = 29;
            }
            int res = 0;
            for (int i = 1; i < month; ++i) {
                res += days[i];
            }
            res += day;
            System.out.println(res);
        }
    }

    private static boolean isR(int year) {
        return year % 4 == 0;
    }

}
