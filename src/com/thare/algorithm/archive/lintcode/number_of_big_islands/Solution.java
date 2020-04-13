package com.thare.algorithm.archive.lintcode.number_of_big_islands;

import java.util.*;

public class Solution {

    class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Queue<Loc> queueZero = new LinkedList<>();
    private Queue<Loc> queueOne = new LinkedList<>();
    private boolean[][] visit;

    private static int[] x = new int[]{0, 0, 1, -1};
    private static int[] y = new int[]{1, -1, 0, 0};

    private int m, n;

    /*
     * @param : a 2d boolean array
     * @param : an integer
     * @return: the number of Islands
     */
    public int numsofIsland(boolean[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        visit = new boolean[m][n];
        Loc start = new Loc(0, 0);
        if (grid[0][0]) {
            queueOne.add(start);
        } else {
            queueZero.add(start);
        }
        visit[0][0] = true;
        int count = 0;
        int res = 0;
        while (!queueZero.isEmpty() || !queueOne.isEmpty()) {
            while (!queueOne.isEmpty()) {
                breadth(grid, queueOne.poll(), true);
                ++count;
            }
            if (count >= k) {
                ++res;
            }
            count = 0;
            while (queueOne.isEmpty() && !queueZero.isEmpty()) {
                breadth(grid, queueZero.poll(), false);
            }
        }
        return res;
    }

    private void breadth(boolean[][] grid, Loc l, boolean oneFlag) {
        boolean flag = true;
        for (int i = 0; i < 4; ++i) {
            int a = l.x + x[i];
            int b = l.y + y[i];
            if (a >= 0 && a < m && b >= 0 && b < n && !visit[a][b] && (oneFlag || flag)) {
                visit[a][b] = true;
                Loc nl = new Loc(a, b);
                if (grid[a][b]) {
                    queueOne.add(nl);
                    flag = false;
                } else {
                    queueZero.add(nl);
                }
            }
        }
    }

}
