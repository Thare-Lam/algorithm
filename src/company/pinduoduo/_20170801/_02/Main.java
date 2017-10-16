package company.pinduoduo._20170801._02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String a = in.next();
            String b = in.next();
            int lenA = a.length();
            int lenB = b.length();
            int[] arrA = new int[lenA];
            int[] arrB = new int[lenB];
            int i;
            for (i = 0; i <lenA; ++i) {
                arrA[i] = a.charAt(i) - '0';
            }
            for (i = 0; i <lenB; ++i) {
                arrB[i] = b.charAt(i) - '0';
            }
            int[] res = mult(arrA, arrB);
            i = res[0] == 0 ? 1 : 0;
            for (; i < res.length; ++i) {
                System.out.print(res[i]);
            }
            System.out.println();
        }
    }

    private static int[] mult(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        for (int i = a.length - 1; i >= 0; --i) {
            for (int j = b.length - 1; j >= 0; --j) {
                res[i + j + 1] += a[i] * b[j];
            }
        }
        for (int k = res.length - 1; k > 0; --k) {
            res[k - 1] += res[k] / 10;
            res[k] %= 10;
        }
        return res;
    }

}
