package com.thare.algorithm.archive.nowcoder.coding_interviews.e02fdb54d7524710a7d664d082bb7811;

public class Solution {

    public void FindNumsAppearOnce(int[] array,int[] num1 , int[] num2) {
        int xor = 0;
        for (int a : array) {
            xor ^= a;
        }
        int x = find(xor);
        for (int a : array) {
            if ((a & x) == 0) {
                num1[0] ^= a;
            } else {
                num2[0] ^= a;
            }
        }
    }

    private int find(int n) {
        int a = 1;
        while ((n & a) == 0) {
            a <<= 1;
        }
        return a;
    }

}
