package com.thare.algorithm.archive.company.jingdong._20170908._01;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            int result = process(s);
            System.out.println(result);
        }
    }

    private static int process(String s) {
        Map<String, Integer> map = new HashMap<>();
        return remove("()" + s, 1, map);
    }

    private static int remove(String s, int r, Map<String, Integer> map) {
        if (s.length() == 2) {
            return 1;
        }
        s = newString(s, r);
        if(map.get(s) != null) {
            return map.get(s);
        }
        int count = 0;
        for (int i = 1, len = s.length(); i < len; ++i) {
            if (s.charAt(i) == ')' && check(s, i)) {
                count += remove(s, i, map);
            }
        }
        map.put(s, count);
        return count;
    }

    private static String newString(String s, int r) {
        char[] ns = new char[s.length() - 2];
        int index = 0;
        for (int i = 1, len = s.length(); i < len; ++i) {
            if (i == r) {
                continue;
            }
            ns[index++] = s.charAt(i);
        }
        return new String(ns);
    }

    private static boolean check(String s, int r) {
        int k = 0;
        for (int i = 1, len = s.length(); i < len; ++i) {
            if (i == r) {
                continue;
            }
            if (s.charAt(i) == '(') {
                ++k;
            } else {
                --k;
                if (k < 0) {
                    return false;
                }
            }
        }
        return true;
    }

}

