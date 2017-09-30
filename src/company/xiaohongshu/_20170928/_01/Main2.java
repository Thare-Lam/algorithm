package company.xiaohongshu._20170928._01;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            String strWithOutRed = removeRed(str);
            String result = process(strWithOutRed.toCharArray());
            System.out.println(result);
        }
    }

    private static String process(char[] str) {
        if (noNumber(str)) {
            return "-1";
        }
        int[] max = new int[2];
        int index = findNum(str, 0, max);
        while (index < str.length) {
            int[] cur = new int[2];
            index = findNum(str, index, cur);
            if (compare(str, cur, max) > 0) {
                max = cur;
            }
        }
        char[] res = new char[max[1] - max[0] + 1];
        int x = 0;
        for (int i = max[0]; i <= max[1]; ++i) {
            res[x++] = str[i];
        }
        return String.valueOf(res);
    }

    private static int findNum(char[] str, int s, int[] index) {
        boolean flag = true;
        int i, j = str.length;
        for (i = s; i < str.length && flag; ++i) {
            if (isNum(str[i])) {
                flag = false;
                index[0] = i;
                for (j = i + 1; j < str.length; ++j) {
                    if (!isNum(str[j])) {
                        index[1] = j - 1;
                        break;
                    }
                }
            }
        }
        if (!flag && index[1] <= index[0]) {
            index[1] = str.length - 1;
        }
        return j + 1;
    }

    private static String removeRed(String str) {
        int index = str.indexOf("RED");
        if (index != -1) {
            return removeRed(str.substring(0, index) + str.substring(index + 3));
        }
        return str;
    }

    private static boolean noNumber(char[] str) {
        for (char c : str) {
            if (isNum(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private static int compare(char[] c, int[] idx1, int[] idx2) {
        int gap = (idx1[1] - idx1[0]) - (idx2[1] - idx2[0]);
        if (gap > 0) {
            return 1;
        } else if (gap < 0) {
            return -1;
        } else {
            int i = idx1[0];
            int j = idx2[0];
            while (i <= idx1[1]) {
                if (c[i] > c[j]) {
                    return 1;
                } else if (c[i] < c[j]) {
                    return -1;
                }
                ++i;
                ++j;
            }
            return 1;
        }
    }

}
