package com.thare.algorithm.archive.lintcode.longest_palindrome;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        char c;
        int count = 0;
        for (int i = 0, len = s.length(); i < len; ++i) {
            c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
                count += 2;
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) {
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        new Solution().longestPalindrome("aaaa");
    }
}
