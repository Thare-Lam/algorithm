package com.thare.algorithm.archive.classic.big_number_multiplication;

import java.util.Arrays;

public class Main {

    public static int[] multiply(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        for (int i = a.length - 1; i >= 0; --i) {
            for (int j = b.length - 1; j >= 0; --j) {
                res[i + j + 1] += a[i] * b[j];
            }
        }
        for (int k = res.length - 1; k >= 1; --k) {
            res[k - 1] += res[k] / 10;
            res[k] %= 10;
        }
        if (res[0] == 0) {
            return Arrays.copyOfRange(res, 1, res.length);
        }
        return res;
    }

    public static char[] multiply(char[] a, char[] b) {
        int[] ia = new int[a.length];
        int[] ib = new int[b.length];
        int i;
        for (i = 0; i < a.length; ++i) {
            ia[i] = a[i] - '0';
        }
        for (i = 0; i < b.length; ++i) {
            ib[i] = b[i] - '0';
        }
        int[] ires = multiply(ia, ib);
        char[] res = new char[ires.length];
        for (i = 0; i < ires.length; ++i) {
            res[i] = (char)(ires[i] + '0');
        }
        return res;
    }

    public static String multiply(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        char[] res = multiply(ca, cb);
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(multiply("72106547548473106236", "982161082972751393").equals("70820244829634538040848656466105986748"));
    }

}
