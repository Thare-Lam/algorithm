package hackerrank.non_divisible_subset;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] recoder = new int[k];
        while (n-- > 0) {
            ++recoder[in.nextInt() % k];
        }
        int count = recoder[0] > 0 ? 1 : 0;
        int i, j;
        for (i = 1, j = k - 1; i < j; ++i, --j) {
            count += Math.max(recoder[i], recoder[j]);
        }
        if (i == j) {
            count += recoder[i] > 0 ? 1 : 0;
        }
        System.out.println(count);
    }
}
