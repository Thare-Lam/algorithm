package company.netease._20180812._03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            char[] s = in.next().toCharArray();
            System.out.println(process(s));
        }
    }

    private static int process(char[] s) {
        int max = 0;
        int cur = 1;
        char last = s[0];
        for (int i = 1; i < s.length; ++i) {
            if (s[i] != last) {
                ++cur;
                last = s[i];
            } else {
                max = Math.max(max, cur);
                cur = 1;
            }
        }
        return Math.max(max, cur);
    }

}
