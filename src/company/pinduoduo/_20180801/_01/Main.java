package company.pinduoduo._20180801._01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(Math.max(arr[0] * arr[1] * arr[n - 1],
                    arr[n - 3] * arr[n - 2] * arr[n - 1]));
        }
    }

}
