package nowcoder.test2016.f9533a71aada4f35867008be22be5b6e;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            System.out.println(last(scanner.nextInt()));
        }
    }

    private static int last(int k) {
        int res = 0;
        for (int i = 2; i <= k; ++i) {
            res = (res + 3) % i;
        }
        return res;
    }
}
