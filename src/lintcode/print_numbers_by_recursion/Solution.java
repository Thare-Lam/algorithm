package lintcode.print_numbers_by_recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        List<Integer> result = new ArrayList<Integer>();
        recursion(n, 0, result);
        return result;
    }

    private void recursion(int n, int ans, List<Integer> result) {
        if (n == 0) {
            if (ans > 0) {
                result.add(ans);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            recursion(n - 1, ans * 10 + i, result);
        }
    }

}
