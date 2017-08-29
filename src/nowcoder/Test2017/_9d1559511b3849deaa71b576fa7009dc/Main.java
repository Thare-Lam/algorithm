package nowcoder.Test2017._9d1559511b3849deaa71b576fa7009dc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.next();
            String b = scanner.next();
            String c;
            int count = 0;
            for (int i = 0, len = a.length(); i <= len; ++i) {
                c = a.substring(0, i) + b + a.substring(i, len);
                if (isHw(c)) {
                    ++count;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isHw(String a) {
        int i = 0, j  = a.length() - 1;
        while (i < j) {
            if (a.charAt(i++) != a.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
