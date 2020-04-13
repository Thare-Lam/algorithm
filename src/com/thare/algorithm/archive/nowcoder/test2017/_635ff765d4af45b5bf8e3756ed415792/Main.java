package com.thare.algorithm.archive.nowcoder.test2017._635ff765d4af45b5bf8e3756ed415792;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            TreeSet<Integer> tsn = new TreeSet<>();
            TreeSet<Integer> tsm = new TreeSet<>();
            for (int i = 0; i < n; ++i) {
                tsn.add(in.nextInt());
            }
            for (int i = 0; i < m; ++i) {
                tsm.add(in.nextInt());
            }
            process(tsn, tsm);
        }
    }

    private static void process(TreeSet<Integer> tsn, TreeSet<Integer> tsm) {
        while (!tsn.isEmpty() && !tsm.isEmpty()) {
            if (tsn.first() < tsm.first()) {
                System.out.print(tsn.pollFirst() + f(tsn, tsm));
            } else if (tsn.first() > tsm.first()) {
                System.out.print(tsm.pollFirst() + f(tsn, tsm));
            } else {
                tsm.pollFirst();
                System.out.print(tsn.pollFirst() + f(tsn, tsm));
            }
        }
        while (!tsn.isEmpty()) {
            System.out.print(tsn.pollFirst() + f(tsn, tsm));
        }
        while (!tsm.isEmpty()) {
            System.out.print(tsm.pollFirst() + f(tsn, tsm));
        }
    }

    private static String f(TreeSet<Integer> tsn, TreeSet<Integer> tsm) {
        return tsn.isEmpty() && tsm.isEmpty() ? "\n" : " ";
    }
}


