package com.thare.algorithm.archive.lintcode.spiral_matrix_ii;

public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int mMin = 0;
        int mMax = n - 1;
        int nMin = 0;
        int nMax = n - 1;
        int x = 0;
        int y = 0;
        int count = 0;
        while (mMin <= mMax && nMin <= nMax) {
            while (y <= nMax) {
                matrix[x][y++] = ++count;
            }
            --y;
            if (++mMin > mMax) {
                break;
            }
            ++x;
            while (x <= mMax) {
                matrix[x++][y] = ++count;
            }
            --x;
            if (nMin > --nMax) {
                break;
            }
            --y;
            while (y >= nMin) {
                matrix[x][y--] = ++count;
            }
            ++y;
            if (mMin > --mMax) {
                break;
            }
            --x;
            while (x >= mMin) {
                matrix[x--][y] = ++count;
            }
            ++x;
            if (++nMin > nMax) {
                break;
            }
            ++y;
        }
        return matrix;
    }
}
