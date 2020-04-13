package com.thare.algorithm.archive.nowcoder.test2017.e27b9fc9c0ec4a17a5064fb6f5ab13e4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt();
            int y = in.nextInt();
            int result = process(x, y);
            System.out.println(result);
        }
    }

    private static int process(int x, int y) {
        int[][] matrix = new int[x + 1][y + 1];
        int i, j;
        for (i = 1; i <= x; ++i) {
            matrix[i][0] = 1;
        }
        for (j = 1; j <= y; ++j) {
            matrix[0][j] = 1;
        }
        for (i = 1; i <= x; ++i) {
            for (j = 1; j <= y; ++j) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[x][y];
    }

}
