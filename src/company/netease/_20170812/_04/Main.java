package company.netease._20170812._04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = in.nextInt();
            }
            process(arr, n);
        }
    }

    private static void process(int[] arr, int n) {
        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }
        int i = n - 1;
        while (i >= 0) {
            System.out.print(arr[i] + " ");
            i -= 2;
        }
        if (i == -2) {
            i = 1;
        } else {
            i = 0;
        }
        while (i < n) {
            System.out.print(arr[i] + (i >= n - 2 ? "\n" : " "));
            i += 2;
        }
    }

}
