package pat.b._1002;

import java.util.Scanner;

enum NUM {
    ling, yi, er, san, si, wu, liu, qi, ba, jiu;
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num, sumStr;
        int i, len, sum;
        while (scanner.hasNext()) {
            num = scanner.next();
            len = num.length();
            sum = 0;
            for (i = len - 1; i >= 0; --i) {
                sum += num.charAt(i) - '0';
            }
            sumStr = sum + "";
            for (i = 0, len = sumStr.length(); i < len; ++i) {
                System.out.print(NUM.values()[sumStr.charAt(i) - '0']);
                if (i < len - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
