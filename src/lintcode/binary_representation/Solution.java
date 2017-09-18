package lintcode.binary_representation;

public class Solution {

    /*
     * @param n: Given a decimal number that is passed in as a string
     * @return: A string
     */
    public String binaryRepresentation(String n) {
        int index = n.indexOf(".");
        if (index == -1) {
            return Integer.toBinaryString(Integer.valueOf(n));
        }
        String intNum = n.substring(0, index);
        String decNum = n.substring(index + 1, n.length());
        String decBin = decimalToBinary(decNum);
        if (decBin == null) {
            return "ERROR";
        }
        return Integer.toBinaryString(Integer.valueOf(intNum)) + (decBin.equals("") ? "" : "." + decBin);
    }

    private String decimalToBinary(String s) {
        return decimalToBinary(s.toCharArray());
    }

    private String decimalToBinary(char[] s) {
        int[] is = new int[s.length];
        for (int i = 0; i < s.length; ++i) {
            is[i] = s[i] - '0';
        }
        return decimalToBinary(is);
    }

    private String decimalToBinary(int[] a) {
        int n = 32;
        StringBuilder sb = new StringBuilder();
        int k;
        while (n-- > 0 && !isAllZero(a)) {
            k = intArrMultTwo(a);
            sb.append(k);
        }
        if (isAllZero(a)) {
            return sb.toString();
        }
        return null;
    }

    private int intArrMultTwo(int[] a) {
        int k = 0;
        for (int i = a.length - 1; i >= 0; --i) {
            a[i] = k + a[i] * 2;
            k = a[i] / 10;
            a[i] %= 10;
        }
        return k;
    }

    private boolean isAllZero(int[] a) {
        for (int i : a) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
        new Solution().binaryRepresentation("1.0"));
    }
}
