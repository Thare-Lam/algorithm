package com.thare.algorithm.archive.lintcode.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param : a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return result;
        }
        int mMin = 0;
        int mMax = m - 1;
        int nMin = 0;
        int nMax = n - 1;
        int x = 0;
        int y = 0;
        while (mMin <= mMax && nMin <= nMax) {
            while (y <= nMax) {
                result.add(matrix[x][y++]);
            }
            --y;
            if (++mMin > mMax) {
                break;
            }
            ++x;
            while (x <= mMax) {
                result.add(matrix[x++][y]);
            }
            --x;
            if (nMin > --nMax) {
                break;
            }
            --y;
            while (y >= nMin) {
                result.add(matrix[x][y--]);
            }
            ++y;
            if (mMin > --mMax) {
                break;
            }
            --x;
            while (x >= mMin) {
                result.add(matrix[x--][y]);
            }
            ++x;
            if (++nMin > nMax) {
                break;
            }
            ++y;
        }
        return result;
    }
}
