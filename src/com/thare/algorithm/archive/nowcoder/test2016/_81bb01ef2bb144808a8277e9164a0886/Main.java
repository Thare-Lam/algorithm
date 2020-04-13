package com.thare.algorithm.archive.nowcoder.test2016._81bb01ef2bb144808a8277e9164a0886;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int r = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            System.out.println((Math.abs(x - x1) + Math.abs(y - y1)) / 2 / r);
        }
    }

}
