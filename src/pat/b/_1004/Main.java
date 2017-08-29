package pat.b._1004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int max = -1, min = 101;
        String maxInfo = "";
        String minInfo = "";
        String name, num;
        int score;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            while (n > 0) {
                name = scanner.next();
                num = scanner.next();
                score = scanner.nextInt();
                if (score > max) {
                    maxInfo = name + " " + num;
                    max = score;
                }
                if (score < min) {
                    minInfo = name + " " + num;
                    min = score;
                }
                --n;
            }
            System.out.println(maxInfo);
            System.out.println(minInfo);
        }
    }
}
