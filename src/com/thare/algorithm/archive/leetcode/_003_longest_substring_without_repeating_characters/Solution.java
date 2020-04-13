package com.thare.algorithm.archive.leetcode._003_longest_substring_without_repeating_characters;

import java.util.*;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char c;
        int max = 0;
        int start = 0;
        int i = 0;
        int len = s.length();
        while (i < len) {
            c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                if (map.get(c) >= start) {
                    max = Math.max(max, Math.max(i - start, i - map.get(c)));
                    start = map.get(c) + 1;
                }
                map.put(c, i);
            }
            ++i;
        }
        max = Math.max(max, len - start);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(
       new Solution().lengthOfLongestSubstring("dvdf"));
    }

}
