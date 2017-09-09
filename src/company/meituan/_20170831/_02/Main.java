package company.meituan._20170831._02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int max = 0;
            int count = 0;
            int a;
            for (int i = 0; i < n; ++i) {
                a = in.nextInt();
                count += a;
                max = Math.max(max, a);
            }
            System.out.println(2 * max <= count ? "Yes" : "No");
        }
    }

}
