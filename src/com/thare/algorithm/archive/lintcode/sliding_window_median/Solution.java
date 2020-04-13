package com.thare.algorithm.archive.lintcode.sliding_window_median;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
     * @param : A list of integers
     * @param : An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        List<Integer> result = new LinkedList<Integer>();
        if (nums == null || nums.length == 0 || nums.length < k) {
            return result;
        }
        Queue<Node> removeQueue = new LinkedList<Node>();
        ArrayList<Node> median = new ArrayList<Node>();

        int i;
        int mid = (k - 1) / 2;
        for (i = 0; i < k; ++i) {
            addMedian(median, removeQueue, nums, i);
        }
        result.add(median.get(mid).value);
        for (i = k; i < nums.length; ++i) {
            median.remove(removeQueue.poll());
            addMedian(median, removeQueue, nums, i);
            result.add(median.get(mid).value);
        }
        return result;
    }

    private void addMedian(ArrayList<Node> median, Queue<Node> removeQueue, int[] nums, int i) {
        Node node = new Node(i, nums[i]);
        removeQueue.add(node);
        int index = halfInsertIndex(median, node);
        median.add(index, node);
    }

    private int halfInsertIndex(ArrayList<Node> median, Node node) {
        int size = median.size();
        int left = 0;
        int right = size - 1;
        int mid;
        int gap;
        while (left <= right) {
            mid = left + (right - left) / 2;
            gap = node.compareTo(median.get(mid));
            if (gap < 0) {
                if (mid == 0 || (mid - 1 >= 0 && node.compareTo(median.get(mid - 1)) >= 0)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (gap == 0) {
                return mid;
            } else {
                if (mid == size - 1 || (mid + 1 < size - 1 && node.compareTo(median.get(mid + 1)) <= 0)) {
                    return mid + 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return left;
    }

    private class Node implements Comparable{

        public int index;
        public int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node)o;
            return this.value - node.value;
        }
    }
}
