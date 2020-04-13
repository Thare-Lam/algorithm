package com.thare.algorithm.archive.leetcode._541_reverse_string_ii;

public class Solution {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int start, len;
        for(start = 0, len = charArray.length; ; start += 2 * k) {
            if(start + k > len) {
                reserve(charArray, start, len - 1);
                break;
            }
            reserve(charArray, start, start + k - 1);
        }
        return String.valueOf(charArray);
    }

    private void reserve(char[] charArray, int start, int end) {
        char temp;
        while(start < end) {
            temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
}
