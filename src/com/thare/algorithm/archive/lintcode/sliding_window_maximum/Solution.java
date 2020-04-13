package com.thare.algorithm.archive.lintcode.sliding_window_maximum;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || nums.length < k) {
            return result;
        }
        Deque<Integer> queue = new LinkedList<Integer>();
        int i;
        for (i = 0; i < k; ++i) {
            saveValue(queue, nums, i);
        }
        result.add(nums[queue.getFirst()]);
        for (i = k; i < nums.length; ++i) {
            if (i - queue.getFirst() == k) {
                queue.removeFirst();
            }
            saveValue(queue, nums, i);
            result.add(nums[queue.getFirst()]);
        }
        return result;
    }

    private void saveValue(Deque<Integer> queue, int[] nums, int n) {
        if (queue.isEmpty()) {
            queue.addFirst(n);
        } else {
            if (nums[n] <= nums[queue.getLast()]) {
                queue.addLast(n);
            } else {
                queue.removeLast();
                while (!queue.isEmpty()) {
                    if (nums[n] > nums[queue.getLast()]) {
                        queue.removeLast();
                    } else {
                        break;
                    }
                }
                queue.addLast(n);
            }
        }
    }
}
