package com.thare.algorithm.archive.nowcoder.test2016._655a43d702cd466093022383c24a38bf;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] c = scanner.next().toCharArray();
            boolean result = false, finish = false;
            int i, j;
            for (i = 0, j = c.length - 1; i < j && !finish; ++i, --j) {
                if (c[i] != c[j]) {
                    finish = true;
                    if (isHw(c, i + 1, j) || isHw(c, i, j - 1)) {
                        result = true;
                    }
                }
            }
            System.out.println(result || i > j? "YES" : "NO");
        }
    }

    private static boolean isHw(char[] c, int s, int e) {
        for (int i = s, j = e; i < j; ++i, --j) {
            if (c[i] != c[j]) {
                return false;
            }
        }
        return true;
    }

}
