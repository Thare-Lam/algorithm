package com.thare.algorithm.archive.nowcoder.coding_interviews._7a0da8fc483247ff8800059e12d7caf1;

public class Solution {

    public int Sum_Solution(int n) {
        boolean flag = n > 0 && (n += Sum_Solution(n - 1)) > 0;
        return n;
    }

}
