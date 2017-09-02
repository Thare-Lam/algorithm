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
        Gene g = new Gene();
        g.init(s, n);
        Aim aim = g.getAim(n);
        if (aim == null) {
            return 0;
        }
        int i = 0, j = 0;
        int min = n;
        while (i < n && j < n) {
            while (j < n && !aim.check()) {
                aim.add(s[j++]);
            }
            if (aim.check()) {
                min = Math.min(min, j - i);
            }
            aim.sub(s[i++]);
        }
        return min;
    }

    private static class Aim {
        int a;
        int ab;
        int c;
        int cb;
        int g;
        int gb;
        int t;
        int tb;

        public Aim() {}

        public void add(char ch) {
            switch (ch) {
                case 'A':
                    if (ab > 0) {
                        --a;
                    }
                    break;
                case 'C':
                    if (cb > 0) {
                        --c;
                    }
                    break;
                case 'G':
                    if (gb > 0) {
                        --g;
                    }
                    break;
                case 'T':
                    if (tb > 0) {
                        --t;
                    }
                    break;
            }
        }

        public void sub(char ch) {
            switch (ch) {
                case 'A':
                    if (ab > 0) {
                        ++a;
                    }
                    break;
                case 'C':
                    if (cb > 0) {
                        ++c;
                    }
                    break;
                case 'G':
                    if (gb > 0) {
                        ++g;
                    }
                    break;
                case 'T':
                    if (tb > 0) {
                        ++t;
                    }
                    break;
            }
        }

        public boolean check() {
            return (ab < 0 || (ab > 0 && a <= 0))
                    && (cb < 0 || (cb > 0 && c <= 0))
                    && (gb < 0 || (gb > 0 && g <= 0))
                    && (tb < 0 || (tb > 0 && t <= 0));
        }
    }

    private static class Gene {
        int a;
        int c;
        int g;
        int t;

        public Gene() {}

        public void init(char[] s, int n) {
            for (int i = 0; i < n; ++i) {
                switch (s[i]) {
                    case 'A':
                        ++a;
                        break;
                    case 'C':
                        ++c;
                        break;
                    case 'G':
                        ++g;
                        break;
                    case 'T':
                        ++t;
                        break;
                }
            }
        }

        private Aim getAim(int n) {
            int avg = n / 4;
            if (a == avg && c == avg && g == avg && t == avg) {
                return null;
            }
            Aim aim = new Aim();
            aim.ab = aim.a = a > avg ? a - avg : -1;
            aim.cb = aim.c = c > avg ? c - avg : -1;
            aim.gb = aim.g = g > avg ? g - avg : -1;
            aim.tb = aim.t = t > avg ? t - avg : -1;
            return aim;
        }
    }

}
