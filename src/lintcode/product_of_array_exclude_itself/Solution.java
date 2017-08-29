package lintcode.product_of_array_exclude_itself;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param : Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        int i;
        long x = 1;
        int size = nums.size();
        List<Long> result = new ArrayList<Long>(size);
        if (size < 2) {
            result.add(1L);
            return result;
        }
        long[] f = new long[size - 1];
        f[size - 2] = nums.get(size - 1);
        for (i = size - 3; i >= 0; --i) {
            f[i] = nums.get(i + 1) * f[i + 1];
        }
        for (i = 0; i < size - 1; ++i) {
            result.add(x * f[i]);
            x *= nums.get(i);
        }
        result.add(x);
        return result;
    }
}
