package com.thare.algorithm.archive.leetcode._052_n_queens;

import java.util.*;

public class Solution {

    private int n;

    private int count;

    private List<Integer> list;

    public int totalNQueens(int n) {
        this.n = n;
        list = new ArrayList<>(n);
        process(0);
        return count;
    }

    private void process(int k) {
        for (int i = 0; i < n; ++i) {
            if (!check(k, i)) {
                continue;
            }
            list.add(i);
            if (k == n - 1) {
                ++count;
                list.remove(k);
                break;
            } else {
                process(k + 1);
                list.remove(k);
            }
        }
    }

    private boolean check(int x, int y) {
        int gapY;
        for (int i = 0, size = list.size(); i < size; ++i) {
            gapY = Math.abs(y - list.get(i));
            if (gapY == 0 || gapY == Math.abs(x - i)) {
                return false;
            }
        }
        return true;
    }

}
