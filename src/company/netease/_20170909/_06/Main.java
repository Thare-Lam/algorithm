package company.netease._20170909._06;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            int result = process(s);
            System.out.println(result);
        }
    }

    private static int process(String s) {
        int len = s.length();
        Set<String> set = new HashSet<>();
        String ns1, ns2;
        for (int i = 0; i < len; ++i) {
            ns1 = s.substring(0, i) + s.substring(i + 1, len);
            for (int j = 0; j < len - 1; ++j) {
                ns2 = ns1.substring(0, j) + s.charAt(i) + ns1.substring(j, len - 1);
                if (isValid(ns2)) {
                    set.add(ns2);
                }
            }
        }
        return set.size() - 1;
    }

    private static boolean isValid(String s) {
        int k = 0;
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (s.charAt(i) == '(') {
                ++k;
            } else {
                --k;
                if (k < 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
