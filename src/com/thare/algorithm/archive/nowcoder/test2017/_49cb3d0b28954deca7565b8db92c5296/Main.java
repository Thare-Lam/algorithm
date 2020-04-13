package com.thare.algorithm.archive.nowcoder.test2017._49cb3d0b28954deca7565b8db92c5296;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            long res = 0;
            long t;
            for (int i = scanner.nextInt(); i > 0; i >>= 1) {
                t = (i + 1) / 2;
                res += t * t;
            }
            System.out.println(res);
        }
    }
}
