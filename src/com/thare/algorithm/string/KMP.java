package com.thare.algorithm.string;

public class KMP {

    public static void main(String[] args) {
        String s = "dsgsdgweqgtewhgertwewet";
        String t = "eqgte";
        System.out.println(new KMP().kmp(s, t));
        System.out.println(s.indexOf(t));
//        int[] r = getNext("ABABAA");
//        for (int i: r) {
//            System.out.println(i);
//        }
    }

    public int kmp(String s, String t) {
        int[] next = getNext(t);
        for (int i = 0, j = 0, sLen = s.length(), tLen = t.length(); i < sLen; ++i) {
            while (j > 0 && s.charAt(i) != t.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == t.charAt(j)) {
                ++j;
            }
            if (j == tLen) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getNext(String t) {
        int len = t.length();
        int[] next = new int[len];
        for (int i = 1, k = 0; i < len; ++i) {
            while (k > 0 && t.charAt(i) != t.charAt(k)) {
                k = next[k - 1];
            }
            if (t.charAt(i) == t.charAt(k)) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    public int kmp2(String s, String t) {
        int[] next = getNext(t);
        int i = 0, j = 0, sLen = s.length(), tLen = t.length();
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j) || j == 0) {
                ++i;
                ++j;
            } else {
                j = next[j - 1];
            }
        }
        return j == tLen ? i - tLen : -1;
    }

    private int[] getNext2(String t) {
        int len = t.length(), i, j, l, r;
        int[] next = new int[len];
        boolean flag;
        for (i = 1; i < len; ++i) {
            for (j = 1; j <= i; ++j) {
                for (l = 0, r = j, flag = true; r <= i && flag; ++l, ++r) {
                    flag = t.charAt(l) == t.charAt(r);
                }
                if (flag) {
                    next[i] = i - j + 1;
                    break;
                }
            }
        }
        return next;
    }

}
