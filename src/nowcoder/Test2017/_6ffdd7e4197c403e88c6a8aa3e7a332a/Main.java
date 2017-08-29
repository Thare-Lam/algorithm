package nowcoder.Test2017._6ffdd7e4197c403e88c6a8aa3e7a332a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int count = 0;
            while (n > 0) {
                n /= 5;
                count += n;
            }
            System.out.println(count);
        }
    }
}
