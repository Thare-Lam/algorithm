package com.thare.algorithm.archive.lintcode.subarray_sum_closest;

import java.util.*;

public class Solution {

    class Item {
        int index;
        int sum;
        Item(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }

    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        PriorityQueue<Item> pq = new PriorityQueue<>(n, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.sum - o2.sum;
            }
        });
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            pq.add(new Item(i, sum));
        }
        Item last = pq.poll();
        Item cur;
        int min = Math.abs(last.sum);
        res[0] = 0;
        res[1] = last.index;
        while (!pq.isEmpty() && min > 0) {
            cur = pq.poll();
            min = f(res, min, last, cur);
            last = cur;
        }
        return res;
    }

    private int f(int[] res, int min, Item a, Item b) {
        if (b.sum - a.sum < min) {
            res[0] = Math.min(a.index, b.index) + 1;
            res[1] = Math.max(a.index, b.index);
            return b.sum - a.sum;
        }
        return min;
    }

}
