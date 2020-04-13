package com.thare.algorithm.archive.hackerrank.matrix_rotation_algo;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        int[][] matrix = new int[m][n];
        int i, j;
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                matrix[i][j] = in.nextInt();
            }
        }
        process(matrix, m, n, r);
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                System.out.print(matrix[i][j] + (j == n - 1 ? "\n" : " "));
            }
        }
    }

    private static void process(int[][] matrix, int m, int n, int r) {
        for (int i = 0; i < Math.min(m, n) / 2; ++i) {
            int[] copy = getRotate(matrix, m, n, i, r);
            rotate(matrix, copy, m, n, i);
        }
    }

    private static void rotate(int[][] matrix, int[] copy, int m, int n, int x) {
        int i;
        int index = 0;
        for (i = x; i < n - 1 - x; ++i) {
            matrix[x][i] = copy[index++];
        }
        for (i = x; i < m - 1 - x; ++i) {
            matrix[i][n - 1 - x] = copy[index++];
        }
        for (i = n - 1 - x; i > x; --i) {
            matrix[m - 1 - x][i] = copy[index++];
        }
        for (i = m - 1 - x; i > x; --i) {
            matrix[i][x] = copy[index++];
        }
    }

    private static int[] getRotate(int[][] matrix, int m, int n, int x, int r) {
        int cur = 2 * (m + n -2) - 8 * x;
        int times = r % cur;
        int[] copy = new int[cur];
        int i;
        int index = 0;
        for (i = x; i < n - 1 - x; ++i) {
            copy[index++] = matrix[x][i];
        }
        for (i = x; i < m - 1 - x; ++i) {
            copy[index++] = matrix[i][n - 1 - x];
        }
        for (i = n - 1 - x; i > x; --i) {
            copy[index++] = matrix[m - 1 - x][i];
        }
        for (i = m - 1 - x; i > x; --i) {
            copy[index++] = matrix[i][x];
        }
        reverse(copy, times);
        return copy;
    }

    private static void reverse(int[] arr, int mid) {
        int i = 0;
        int j = mid - 1;
        while (i < j) {
            swap(arr, i++, j--);
        }
        i = mid;
        j = arr.length - 1;
        while (i < j) {
            swap(arr, i++, j--);
        }
        i = 0;
        j = arr.length - 1;
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
