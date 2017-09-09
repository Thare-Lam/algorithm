package company.jingdong._20170908._02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            long result = process(n);
            System.out.println(result);
        }
    }

    private static long process(int n) {
        long count = 1;
        for(int i = 2;i <= n; ++i) {
            count += 1 + (i - 1) * 2;
            for (int j = 1; j * j <= n; ++j) {
                count += 2;
            }
            count %= 1000000007;
        }
        return count;
    }
}

