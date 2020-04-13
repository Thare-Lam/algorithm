package com.thare.algorithm.archive.company.youzan._20170921._02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int k = in.nextInt();
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = in.nextInt();
                }
            }
            process(matrix, k, m, n);
        }
    }

    private static void process(int[][] matrix, int k, int m, int n) {
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] > k) {
                y--;
            } else if (matrix[x][y] < k) {
                x++;
            } else {
                System.out.println(x + " " + y);
                return;
            }
        }
        System.out.println("-1 -1");
    }
}
