package hackerrank.angry_professor;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        for (int i = 0; i < m; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            int count = 0;
            for (int j = 0; j < n; ++j) {
                count += in.nextInt() <= 0 ? 1 : 0;
            }
            System.out.println(count >= k ? "NO" : "YES");
        }
    }

}
