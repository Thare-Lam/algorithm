package com.thare.algorithm.archive.lintcode.palindrome_number;

public class Solution {
    /*
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean palindromeNumber(int num) {
        int temp = num;
        int num2 = 0;
        while (temp > 0) {
            num2 = num2 * 10 + temp % 10;
            temp /= 10;
        }
        return num == num2;
    }
}
