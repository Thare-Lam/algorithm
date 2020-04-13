package com.thare.algorithm.archive.b._1001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, count;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            count = 0;
            while (n > 1) {
                if ((n & 1) == 0) {
                    n >>= 1;
                } else {
                    n = ((n << 1) + n + 1) >> 1;
                }
                ++count;
            }
            System.out.println(count);
        }
    }
}
