package lintcode.string_to_integer_ii;

public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        char[] s = str.trim().toCharArray();
        int i;
        int start = -1;
        int end = s.length - 1;
        int result = 0;
        int last = 0;
        int mul = 1;
        boolean negative = false;
        for (i = 0; i < s.length; ++i) {
            if (s[i] == '-' || s[i] == '+') {
                if (start < 0) {
                    start = i;
                } else {
                    if (s[i - 1] == '-' || s[i - 1] == '+') {
                        return 0;
                    }
                    end = i - 1;
                    break;
                }
            } else if (s[i] >= '0' && s[i] <= '9'){
                if (start < 0) {
                    start = i;
                }
            } else {
                if (start >= 0) {
                    end = i - 1;
                    break;
                }
            }
        }
        if (start < 0) {
            return 0;
        }
        if (s[start] == '-') {
            ++start;
            negative = true;
        } else if (s[start] == '+') {
            ++start;
        }
        for (i = end; i >= start; --i) {
            result += (s[i] - '0') * mul;
            if (result < last) {
                if (start == 1) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            last = result;
            mul *= 10;
        }
        if (negative) {
            result = -result;
        }
        return result;
    }
}
