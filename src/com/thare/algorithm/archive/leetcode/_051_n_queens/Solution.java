package com.thare.algorithm.archive.leetcode._051_n_queens;

import java.util.*;

public class Solution {

    private List<List<String>> res = new ArrayList<>();

    private List<Integer> list;

    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        list = new ArrayList<>(n);
        process(0);
        return res;
    }

    private void process(int k) {
        for (int i = 0; i < n; ++i) {
            if (!check(k, i)) {
                continue;
            }
            list.add(i);
            if (k == n - 1) {
                addRes();
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

    private void addRes() {
        char[] c;
        List<String> sl = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            c = new char[n];
            Arrays.fill(c, '.');
            c[list.get(i)] = 'Q';
            sl.add(String.valueOf(c));
        }
        res.add(sl);
    }

}
