package com.thare.algorithm.archive.leetcode._056_merge_intervals;

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        intervals.sort((o1, o2) -> (o1.start - o2.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval cur : intervals) {
            if (end >= cur.start) {
                end = Math.max(end, cur.end);
            } else {
                res.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

}
