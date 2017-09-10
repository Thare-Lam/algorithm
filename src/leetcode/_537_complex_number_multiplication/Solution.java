package leetcode._537_complex_number_multiplication;

public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int m, n;
        int x1, x2, y1, y2;
        String[] xy1 = a.split("\\+");
        String[] xy2 = b.split("\\+");
        x1 = Integer.parseInt(xy1[0]);
        y1 = Integer.parseInt(xy1[1].substring(0, xy1[1].length()-1));
        x2 = Integer.parseInt(xy2[0]);
        y2 = Integer.parseInt(xy2[1].substring(0, xy2[1].length()-1));
        m = x1 * x2 - (y1 * y2);
        n = x1 * y2 + x2 * y1;

        return String.format("%d+%di", m, n);
    }
}