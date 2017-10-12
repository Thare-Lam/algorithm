package nowcoder.test2017._4d1afe11171c44a385287e29092cdb3f;

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
        int count = 0;
        int x = 1;
        while (x <= n) {
            if(isLucky(x++)) {
                ++count;
            }
        }
        return count;
    }

    private static boolean isLucky(int x) {
        return f(x) == g(x);
    }

    private static int f(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    private static int g(int x) {
        int sum = 0;
        while (x > 0) {
            ++sum;
            x &= x - 1;
        }
        return sum;
    }
}


