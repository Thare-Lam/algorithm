package com.thare.algorithm.archive.nowcoder.coding_interviews._762836f4d43d43ca9deb273b3de8e1f4;

import java.util.PriorityQueue;

public class Solution {

    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int a : numbers) {
            if (a != 0) {
                pq.add(a);
            } else {
                ++count;
            }
        }
        int last = pq.poll();
        int cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            if (cur == last) {
                return false;
            }
            count -= cur - last - 1;
            last = cur;
        }
        return count > -1;
    }

}
