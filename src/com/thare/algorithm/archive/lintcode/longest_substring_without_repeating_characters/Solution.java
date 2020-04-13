package com.thare.algorithm.archive.lintcode.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int max = 0;
        char c;
        for (int i = 0; i < len; ++i) {
            c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                max = Math.max(max, i - start);
                start = map.get(c) + 1;
            }
            map.put(c, i);
        }
        return Math.max(max, len - start);
    }
}
