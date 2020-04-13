package com.thare.algorithm.archive.nowcoder.coding_interviews._59ac416b4b944300b617d4f7f111b215;

public class Solution {

    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int xor = num1 ^ num2;
            int and = (num1 & num2) << 1;
            num1 = xor;
            num2 = and;
        }
        return num1;
    }

}
