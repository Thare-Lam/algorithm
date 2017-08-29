package lintcode.single_number_iii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param a : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] a) {
        int x = 0;
        int y = 0;
        int z;
        int xor = 0;
        for (int i : a) {
            xor ^= i;
        }
        z = xor - (xor & (xor - 1));
        for (int i : a) {
            if ((i & z) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        result.add(x);
        result.add(y);
        return result;
    }
}
