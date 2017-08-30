package base.kmp;

import utils.TestUtils;

public class Main {

    public static int kmp(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int lenB = cb.length;
        int[] next = calNext(cb);
        int k = -1;
        for (int i = 0; i < ca.length; ++i) {
            while (k > -1 && cb[k + 1] != ca[i]) {
                k = next[k];
            }
            if (cb[k + 1] == ca[i]) {
                ++k;
            }
            if (k == lenB - 1) {
                return i - k;
            }
        }
        return -1;
    }

    private static int[] calNext(char[] s) {
        int len = s.length;
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < len; ++i) {
            while (k > -1 && s[k + 1] != s[i]) {
                k = next[k];
            }
            if (s[k + 1] == s[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (String[] sa : TestUtils.SUB_STRING_ARRAY) {
            if (sa[0].indexOf(sa[1]) != kmp(sa[0], sa[1])) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

}
