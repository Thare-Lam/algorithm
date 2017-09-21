package company.cmbchina._20170921._01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] time = new int[24];
            while (n-- > 0) {
                int s = in.nextInt();
                int e = in.nextInt();
                while (s < e) {
                    time[s++] += 1;
                }
            }
            int max = 0;
            for (int i = 0; i < 24; ++i) {
                max = Math.max(max, time[i]);
            }
            System.out.println(max);
        }
    }

}
