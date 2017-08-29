package nowcoder.Test2017.c96d6acc025541ffb79c579688f8d003;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n < 4) {
                System.out.println(0);
                continue;
            }
            int i, j;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(2);
            for (i = 3; i <= n - 2; i += 2) {
                if (isPrime(i)) {
                    list.add(i);
                }
            }
            int count = 0;
            int temp;
            for (i = 0, j = list.size() - 1; i < j;) {
                temp = list.get(i) + list.get(j);
                if (temp < n) {
                    ++i;
                } else if (temp > n) {
                    --j;
                } else {
                    ++count;
                    ++i;
                    --j;
                }
            }
            if ((n & 1) == 0 && isPrime(n / 2)) {
                ++count;
            }
            System.out.println(count);
        }
    }

    private static boolean isPrime(int k) {
        if (k <= 2) {
            return k == 2;
        }
        for (int i = 2; i <= Math.pow(k, 0.5); ++i) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }

}
