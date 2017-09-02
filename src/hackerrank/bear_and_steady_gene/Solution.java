package hackerrank.bear_and_steady_gene;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] s = in.next().toCharArray();
        System.out.println(process(n, s));
    }

    private static int process(int n, char[] s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);
        for (char c : s) {
            map.put(c, map.get(c) + 1);
        }
        int i = 0, j = 0, min = n;
        while (i < n && j < n) {
            while (j < n && !isSteady(map, n)) {
                map.put(s[j], map.get(s[j]) - 1);
                ++j;
            }
            if (isSteady(map, n)) {
                min = Math.min(min, j - i);
            }
            map.put(s[i], map.get(s[i]) + 1);
            ++i;
        }
        return min;
    }

    private static boolean isSteady(Map<Character, Integer> map, int n) {
        int avg = n / 4;
        for (Integer v : map.values()) {
            if (v > avg) {
                return false;
            }
        }
        return true;
    }

}
