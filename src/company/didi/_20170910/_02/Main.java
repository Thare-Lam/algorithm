package company.didi._20170910._02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int result = process(n);
            System.out.println(result);
        }
    }

    private static int process(int n) {
        int[] base = new int[]{2, 3, 5};
        int len = 3;
        int[] index = new int[len];
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i = 1, j, min;
        while (i < n) {
            min = Integer.MAX_VALUE;
            for (j = 0; j < len; j++) {
                min = Math.min(min, ugly[index[j]] * base[j]);
            }
            for (j = 0; j < len; j++) {
                if (min == ugly[index[j]] * base[j]) {
                    ++index[j];
                }
            }
            ugly[i++] = min;
        }
        return ugly[n - 1];
    }

}
