package company.netease._20180812._01;

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
        int r = 0;
        for (char c : s) {
            r |= 1 << c - 'A';
            if (countOne(r) > 2) {
                return 0;
            }
        }
        return countOne(r);
    }

    private static int countOne(int x) {
        int count = 0;
        while (x > 0) {
            x &= x - 1;
            ++count;
        }
        return count;
    }

}
