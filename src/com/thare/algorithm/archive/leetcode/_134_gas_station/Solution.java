package com.thare.algorithm.archive.leetcode._134_gas_station;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] remain = new int[n];
        for (int i = 0; i < n; ++i) {
            remain[i] = gas[i] - cost[i];
        }
        int start = 0;
        int cur = 1;
        int sum = remain[start];
        while (cur - start < n && start < n) {
            while (cur - start < n && sum >= 0) {
                sum += getRemain(remain, cur++);
            }
            if (cur - start == n && sum >= 0) {
                return start;
            }
            sum -= remain[start++];
        }
        if (cur - start == n && sum >= 0) {
            return start;
        }
        return -1;
    }

    private int getRemain(int[] remain, int cur) {
        return remain[cur % remain.length];
    }

}
