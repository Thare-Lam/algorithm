package com.thare.algorithm.archive.leetcode._054_spiral_matrix;

import java.util.*;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        int x = 0, y = 0;
        int xMin = 0, xMax = m - 1, yMin = 0, yMax = n - 1;
        while (xMin <= xMax && yMin <= yMax) {
            while (y <= yMax) {
                res.add(matrix[x][y++]);
            }
            --y;
            ++x;
            ++xMin;
            if (xMin > xMax) {
                break;
            }
            while (x <= xMax) {
                res.add(matrix[x++][y]);
            }
            --x;
            --y;
            --yMax;
            if (yMin > yMax) {
                break;
            }
            while (y >= yMin && yMin <= yMax) {
                res.add(matrix[x][y--]);
            }
            ++y;
            --x;
            --xMax;
            if (xMin > xMax) {
                break;
            }
            while (x >= xMin && xMin <= xMax) {
                res.add(matrix[x--][y]);
            }
            ++x;
            ++y;
            ++yMin;
            if (yMin > yMax) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{
                new int[]{1,2}
        }));
    }

}
