package lintcode.data_stream_median;

import java.util.PriorityQueue;

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        int len = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(len, (l, r) -> r.compareTo(1));
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(len);
        int[] result = new int[len];
        for (int i = 0; i < len; ++i) {
            add(maxHeap, minHeap, nums, i);
            result[i] = maxHeap.peek();
        }
        return result;
    }

    private void add(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int[] nums, int i) {
        maxHeap.add(nums[i]);
        if (((i & 1) == 0)){
            if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int max = maxHeap.poll();
                int min = minHeap.poll();
                maxHeap.add(min);
                minHeap.add(max);
            }
        } else {
            minHeap.add(maxHeap.poll());
        }
    }
}
