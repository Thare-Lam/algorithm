package leetcode._051_n_queens;

import java.util.*;

public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] matrix = new char[n][n];
        byte[][] visit = new byte[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(matrix[i], '.');
        }
        process(res, matrix, visit, n, 0);
        return res;
    }

    private void process(List<List<String>> res, char[][] matrix, byte[][] visit, int n, int k) {
        for (int i = 0; i < n; ++i) {
            if (visit[k][i] == 0) {
                char[][] newMatrix = copy(matrix, n);
                newMatrix[k][i] = 'Q';
                if (k == n - 1) {
                    res.add(convertCharArr(newMatrix, n));
                } else {
                    byte[][] newVisit = copy(visit, n);
                    updateVisit(newVisit, n, k, i);
                    process(res, newMatrix, newVisit, n, k + 1);
                }
            }
        }
    }

    private void updateVisit(byte[][] visit, int n, int x, int y) {
        int i;
        for (i = 0; i < n; ++i) {
            visit[x][i] = 1;
            visit[i][y] = 1;
        }
        int[] xd = new int[]{-1, -1, 1, 1};
        int[] yd = new int[]{-1, 1, -1, 1};
        int x1, y1;
        for (i = 0; i < 4; ++i) {
            x1 = x;
            y1 = y;
            while (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n) {
                visit[x1][y1] = 1;
                x1 += xd[i];
                y1 += yd[i];
            }
        }
    }

    private List<String> convertCharArr(char[][] m, int n) {
        List<String> list = new ArrayList<>(n);
        for (char[] s: m) {
            list.add(String.valueOf(s));
        }
        return list;
    }

    private char[][] copy(char[][] m, int n) {
        char[][] copy = new char[n][n];
        for (int i = 0; i < n; ++i) {
            copy[i] = Arrays.copyOf(m[i], n);
        }
        return copy;
    }

    private byte[][] copy(byte[][] b, int n) {
        byte[][] copy = new byte[n][n];
        for (int i = 0; i < n; ++i) {
            copy[i] = Arrays.copyOf(b[i], n);
        }
        return copy;
    }

    public static void main(String[] args) {
        for (List<String> list : new Solution().solveNQueens(6)) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

}
