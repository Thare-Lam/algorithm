package com.thare.algorithm.archive.b._1003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strList;
        int n, i;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            strList = new String[n];
            for (i = 0; i < n; ++i) {
                strList[i] = scanner.next();
            }
            for (i = 0; i < n; ++i) {
                System.out.println(isPat(strList[i]) ? "YES" : "NO");
            }
        }
    }

    private static boolean isPat(String str) {
        boolean flag = true;
        boolean flagA = false;
        int indexP = -1;
        int indexT = -1;
        int i, len;
        int a, b, c;
        for (i = 0, len = str.length(); i < len && flag; ++i) {
            switch (str.charAt(i)) {
                case 'P':
                    if (indexP == -1) {
                        indexP = i;
                    } else {
                        flag = false;
                    }
                    break;
                case 'A':
                    flagA = true;
                    break;
                case 'T':
                    if (indexT == -1) {
                        indexT = i;
                    } else {
                        flag = false;
                    }
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        if (indexP == -1 || indexT == -1 || !flagA) {
            return false;
        }
        a = indexP;
        b = indexT - indexP - 1;
        c = len - 1 - indexT;
        return (a == 0 && c == 0) || a * b == c;
    }
}
