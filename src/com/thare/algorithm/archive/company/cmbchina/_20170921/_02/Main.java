package com.thare.algorithm.archive.company.cmbchina._20170921._02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String pwd = in.next();
            int result = process(pwd.toCharArray());
            System.out.println(result);
        }
    }

    private static int process(char[] s) {
        int res = 0;
        boolean numFlag = false;
        boolean lowFlag = false;
        boolean upFlag = false;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] >= '0' && s[i] <= '9') {
                numFlag = true;
            } else if (s[i] >= 'A' && s[i] <= 'Z') {
                upFlag = true;
            } else if (s[i] >= 'a' && s[i] <= 'z') {
                lowFlag = true;
            }
        }
        int flagCount = 0;
        if (!numFlag) {
            ++flagCount;
        }
        if (!lowFlag) {
            ++flagCount;
        }
        if (!upFlag) {
            ++flagCount;
        }
        if (s.length < 6) {
            boolean serflag = false;
            for (int i = 0; i <= s.length - 3; i += 3) {
                if (((s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= 'a' && s[i] <= 'z'))
                        && s[i] == s[i + 1] && s[i + 1] == s[i + 2]) {
                    serflag = true;
                    s[i + 2] = '-';
                }
            }
            int t = serflag ? 1 : 0;
            res = Math.max(6 - s.length, flagCount - t) + t;
        } else if (s.length > 20) {
            int gap = s.length - 20;
            res = gap;
            char[] np = new char[20];
            int index = 0;
            for (int i = 0; i <= s.length - 3 && gap > 0 && index < 20; i += 3) {
                if (((s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= 'a' && s[i] <= 'z'))
                        && s[i] == s[i + 1] && s[i + 1] == s[i + 2]) {
                    if (gap > 1) {
                        np[index++] = s[i];
                        gap -= 2;
                    } else {
                        np[index++] = s[i];
                        np[index++] = s[i];
                        gap -= 1;
                    }
                }
            }
            int nres = 0;
            for (int i = 0; i <= s.length - 3; i += 3) {
                if (((np[i] >= 'A' && np[i] <= 'Z') || (np[i] >= 'a' && np[i] <= 'z'))
                        && np[i] == np[i + 1] && np[i + 1] == np[i + 2]) {
                    ++nres;
                    np[i + 2] = '-';
                }
            }
            res += Math.max(nres, flagCount);
        } else {
            for (int i = 0; i <= s.length - 3; i += 3) {
                if (((s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= 'a' && s[i] <= 'z'))
                        && s[i] == s[i + 1] && s[i + 1] == s[i + 2]) {
                    ++res;
                    s[i + 2] = '-';
                }
            }
            res = Math.max(res, flagCount);
        }
        return res;
    }

}
