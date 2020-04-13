package com.thare.algorithm.archive.nowcoder.test2017._6fc8716ee33e4cc59d58d7e18712094e;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[]{16276, 651, 26, 1};
        while (scanner.hasNext()) {
            String str = scanner.next();
            int j = 0;
            int index = 0;
            for (int i = 0, len = str.length(); i < len && j < 4; ++i) {
                index += arr[j++] * (str.charAt(i) - 'a') + 1;
            }
            System.out.println(index - 1);
        }
    }
}

