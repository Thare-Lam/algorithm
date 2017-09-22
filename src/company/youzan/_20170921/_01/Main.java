package company.youzan._20170921._01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String result = process(s.toCharArray());
            System.out.println(result);
        }
    }

    private static String process(char[] s) {
        reverse(s, 0, s.length - 1);
        int i, j;
        for (i = 0; i < s.length; ++i) {
            if (isWord(s[i])) {
                for (j = i + 1; j < s.length; ++j) {
                    if (!isWord(s[j])) {
                        reverse(s, i, j - 1);
                        break;
                    } else if (j == s.length - 1) {
                        reverse(s, i, j);
                        break;
                    }
                }
                i = j;
            }
        }
        return String.valueOf(s);
    }

    private static void reverse(char[] s, int start, int end) {
        int i = start;
        int j = end;
        char c;
        while (i < j) {
            c = s[i];
            s[i] = s[j];
            s[j] = c;
            ++i;
            --j;
        }
    }

    private static boolean isWord(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z' || c == '\'');
    }

}
