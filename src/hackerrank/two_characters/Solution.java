package hackerrank.two_characters;

import java.util.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        int result = process(s.toCharArray());
        System.out.println(result);
    }

    private static int process(char[] s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char c;
        for (int i = 0; i < s.length; ++i) {
            c = s[i];
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        int max = 0;
        Set<Character> keySet = map.keySet();
        for (char i : keySet) {
            for (char j : keySet) {
                if (i == j) {
                    continue;
                }
                List<Integer> a = map.get(i);
                List<Integer> b = map.get(j);
                if (canMerge(a, b)) {
                    max = Math.max(max, a.size() + b.size());
                }
            }
        }
        return max;
    }

    private static boolean canMerge(List<Integer> a, List<Integer> b) {
        if (Math.abs(a.size() - b.size()) < 2) {
            if (a.size() == b.size()) {
                return judgeEqual(a, b) || judgeEqual(b, a);
            } else if (a.size() < b.size()) {
                return judgeNotEqual(a, b);
            } else {
                return judgeNotEqual(b, a);
            }
        }
        return false;
    }

    private static boolean judgeEqual(List<Integer> a, List<Integer> b) {
        if (a.get(0) > b.get(0)) {
            return false;
        }
        for (int i = 1; i < a.size(); ++i) {
            if (!(a.get(i) > b.get(i - 1) && a.get(i) < b.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean judgeNotEqual(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); ++i) {
            if (!(a.get(i) > b.get(i) && a.get(i) < b.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

}
