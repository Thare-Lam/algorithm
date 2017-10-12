package nowcoder.test2017.ac61207721a34b74b06597fe6eb67c52;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            boolean postive = true;
            if (m < 0) {
                postive = false;
                m = -m;
            }
            StringBuilder sb = new StringBuilder();
            int mod;
            while (m > 0) {
                mod = m % n;
                sb.append(mod > 9 ? (char)('A' + mod - 10) + "" : mod + "");
                m /= n;
            }
            if (!postive) {
                System.out.print("-");
            }
            for (int i = sb.length() - 1; i >= 0; --i) {
                System.out.print(sb.charAt(i));
            }
            System.out.println();
        }
    }
}
