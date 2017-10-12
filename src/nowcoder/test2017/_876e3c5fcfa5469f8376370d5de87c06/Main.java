package nowcoder.test2017._876e3c5fcfa5469f8376370d5de87c06;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int i;
            for (i = 0; i < n; ++i) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(fun(arr));
        }
    }

    private static int fun(int[] arr) {
        if (arr[0] > 1) {
            return 1;
        } else if (arr.length == 1) {
            return arr[0] + 1;
        }
        int k = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] - k > 1) {
                return k + 1;
            } else {
                k += arr[i];
            }
        }
        return k + 1;
    }

}
