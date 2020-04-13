package com.thare.algorithm.archive.nowcoder.test2016._3a571cdc72264d76820396770a151f90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n <= 2) {
                System.out.println(0);
                continue;
            }
            List<Integer> list = new ArrayList<>();
            int i, gap, current;
            int index = -1, max = -1;
            int last = scanner.nextInt();
            for (i = 1; i < n; ++i) {
                current = scanner.nextInt();
                gap = last - current;
                last = current;
                if (Math.abs(gap) > max) {
                    max = Math.abs(gap);
                    index = i - 1;
                }
                list.add(gap);
            }
            if (index > 0) {
                max = Math.min(max, Math.abs(list.get(index) + list.get(index - 1)));
            }
            if (index < list.size() - 1) {
                max = Math.min(max, Math.abs(list.get(index) + list.get(index + 1)));
            }
            System.out.println(max);
        }
    }

}
