package company.pinduoduo._20170902._01;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int i, j;
            int[] candy = new int[m];
            Bear[] bears = new Bear[n];
            for (i = 0; i < m; ++i) {
                candy[i] = in.nextInt();
            }
            int pow, hungry;
            for (i = 0; i < n; ++i) {
                pow = in.nextInt();
                hungry = in.nextInt();
                bears[i] = new Bear(i, pow, hungry);
            }
            Arrays.sort(candy);
            Arrays.sort(bears);
            int[] eated = new int[m];
            for (i = bears.length - 1; i >= 0 && bears[i].h > 0; --i) {
                for (j = candy.length - 1; j >= 0; --j) {
                    if (eated[j] == 1) {
                        continue;
                    }
                    if (candy[j] <= bears[i].h) {
                        bears[i].h -= candy[j];
                        eated[j] = 1;
                    }
                }
            }
            int[] res = new int[n];
            for (i = 0; i < bears.length; ++i) {
                res[bears[i].i] = bears[i].h;
            }
            for (i = 0; i < n; ++i) {
                System.out.println(res[i]);
            }
        }
    }

    private static class Bear implements Comparable<Bear> {
        int i;
        int p;
        int h;

        public Bear(int i, int p, int h) {
            this.i = i;
            this.p = p;
            this.h = h;
        }

        @Override
        public int compareTo(Bear o) {
            return this.p - o.p;
        }
    }

}
