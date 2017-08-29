package nowcoder.Test2017.cd763d8541fc4243b8d3b967bb6d6b6a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, i, min;
        int[] x, y;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            x = new int[n];
            y = new int[n];
            min = Integer.MAX_VALUE;
            for (i = 0; i < n; ++i) {
                x[i] = scanner.nextInt();
            }
            for (i = 0; i < n; ++i) {
                y[i] = scanner.nextInt();
            }
            for (i = 0; i < n; ++i) {
                min = Math.min(min, x[i] + y[i] - 2);
            }
            System.out.println(min);
        }
    }
}
