package company.netease._20170812._05;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt();
            int f = in.nextInt();
            int d = in.nextInt();
            int p = in.nextInt();
            if (d / x < f) {
                System.out.println(d / x);
            } else {
                System.out.println(f + (d - f * x) / (x + p));
            }
        }
    }

}
