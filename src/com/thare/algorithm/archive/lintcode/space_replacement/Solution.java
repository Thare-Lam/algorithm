package com.thare.algorithm.archive.lintcode.space_replacement;

public class Solution {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        int i;
        int spaceCount = 0;
        char space = ' ';
        for (i = 0; i < length; i++) {
            if (string[i] == space) {
                spaceCount++;
            }
        }
        int newLen = length + spaceCount * 2;
        int index = newLen - 1;
        for (i = length - 1; i >= 0; i--) {
            if (string[i] == space) {
                string[index--] = '0';
                string[index--] = '2';
                string[index--] = '%';
            } else {
                string[index--] = string[i];
            }
        }
        return newLen;
    }
}
