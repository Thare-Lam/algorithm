package hackerrank.extra_long_factorials;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        BigInteger res = new BigInteger("1");
        while (n > 0) {
            res = res.multiply(new BigInteger(String.valueOf(n--)));
        }
        System.out.println(res);
    }

}
