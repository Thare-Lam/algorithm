package lintcode.majority_number;

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int a = 0;
        int count = 0;
        for (int i : nums) {
            if (i == a) {
                ++count;
            } else {
                if (count == 0) {
                    a = i;
                    count = 1;
                } else {
                    --count;
                }
            }
        }
        return a;
    }
}
