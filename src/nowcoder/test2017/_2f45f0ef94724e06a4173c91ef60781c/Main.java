package nowcoder.test2017._2f45f0ef94724e06a4173c91ef60781c;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a < 0 || a > 1024 || b < 0 || b > 1024) {
                System.out.println(-1);
            } else {
                System.out.println(a == b ? 1 : 0);
            }
        }
    }

}
