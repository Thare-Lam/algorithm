package lintcode.median_of_two_sorted_arrays;

public class Solution {
    /**
     * @param a: An integer array.
     * @param b: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] a, int[] b) {
        int len = a.length + b.length;
        int mid = len / 2;
        if ((len & 1) == 0) {
            return (recursion(a, b, 0, 0, mid) + recursion(a, b, 0, 0, mid + 1)) / 2;
        } else {
            return recursion(a, b, 0, 0, mid + 1);
        }
    }

    private double recursion(int[] a, int[] b, int sa, int sb, int k) {
        if (sa >= a.length) {
            return b[sb + k - 1];
        }
        if (sb >= b.length) {
            return a[sa + k - 1];
        }
        if (k == 1) {
            return Math.min(a[sa], b[sb]);
        }
        int nsa = sa + k / 2 - 1;
        int nsb = sb + k / 2 - 1;
        int va = nsa < a.length ? a[nsa] : Integer.MAX_VALUE;
        int vb = nsb < b.length ? b[nsb] : Integer.MAX_VALUE;
        if (va < vb) {
            return recursion(a, b, nsa + 1, sb, k - k / 2);
        } else {
            return recursion(a, b, sa, nsb + 1, k - k / 2);
        }
    }
}
