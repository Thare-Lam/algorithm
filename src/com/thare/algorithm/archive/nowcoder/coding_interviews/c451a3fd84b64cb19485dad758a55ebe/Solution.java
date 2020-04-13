package com.thare.algorithm.archive.nowcoder.coding_interviews.c451a3fd84b64cb19485dad758a55ebe;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        new Solution().FindContinuousSequence(3);
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int len = (sum + 1) / 2;
        int s = 0;
        int i = 1;
        int j = 1;
        while (j <= len) {
            while (s < sum && j <= len) {
                s += j++;
            }
            while (s > sum) {
                s -= i++;
            }
            if (s == sum && j - i > 1) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int a = i; a < j; ++a) {
                    list.add(a);
                }
                res.add(list);
                s -= i++;
            }
        }
        System.out.println(res);
        return res;
    }

}
