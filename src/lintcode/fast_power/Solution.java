package lintcode.fast_power;

public class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        if (b == 1) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long result = 1;
        long al = a;
        while (n > 0) {
            if ((n & 1) > 0) {
                result = result * al % b;
            }
            n >>= 1;
            al = al * al % b;
        }
        return (int) result;
    }
}
