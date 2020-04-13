package com.thare.algorithm.archive.hackerrank.funny_string;

import java.util.Scanner;

public class Solution {

    static String funnyString(String s){
        for (int len = s.length(), i = 1, j = len - 2; i < len && j >= 0; ++i, --j) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != Math.abs(s.charAt(j) - s.charAt(j + 1))) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }

}
