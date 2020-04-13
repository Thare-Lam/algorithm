package com.thare.algorithm.archive.nowcoder.test2017._5a304c109a544aef9b583dce23f5f5db;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int max = Integer.MIN_VALUE;
            int current = 0;
            while (n > 0) {
                current += scanner.nextInt();
                max = Math.max(max, current);
                if (current < 0) {
                    current = 0;
                }
                --n;
            }
            System.out.println(max);
        }
    }
}
