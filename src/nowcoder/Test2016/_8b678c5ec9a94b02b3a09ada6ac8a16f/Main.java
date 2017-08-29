package nowcoder.Test2016._8b678c5ec9a94b02b3a09ada6ac8a16f;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int[][] tb = new int[q][2];
            int i, j, k, a, b, count = 0;
            boolean c;
            Set<Integer> setA = new HashSet<>();
            for (i = 0; i < p; ++i) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                for (j = a; j <= b; ++j) {
                    setA.add(j);
                }
            }
            for (i = 0; i < q; ++i) {
                tb[i][0] = scanner.nextInt();
                tb[i][1] = scanner.nextInt();
            }
            for (i = l; i <= r; ++i) {
                c = false;
                for (j = 0; j < tb.length && !c; ++j) {
                    for (k = tb[j][0]; k <= tb[j][1]; ++k) {
                        if (setA.contains(k + i)) {
                            c = true;
                            ++count;
                            break;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

}
