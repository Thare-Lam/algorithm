package lintcode.search_for_a_range;

public class Solution {
    /**
     *@param a : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] a, int target) {
        int mid = fun(a, 0, a.length - 1, target, 0);
        if (mid == -1) {
            return new int[]{-1, -1};
        }
        int lmid = fun(a, 0, mid - 1, target, -1);
        int rmid = fun(a, mid + 1, a.length - 1, target, 1);
        return new int[]{lmid == -1 ? mid : lmid, rmid == -1 ? mid : rmid};
    }

    private int fun(int[] a, int start, int end, int target, int mode) {
        for (;;) {
            if (start > end) {
                return -1;
            }
            int mid = start + (end - start) / 2;
            if (a[mid] < target) {
                start = mid + 1;
            } else if (a[mid] > target) {
                end = mid - 1;
            } else {
                switch (mode) {
                    case -1:
                        int lmid = fun(a, start, mid - 1, target, -1);
                        return lmid >= 0 ? lmid : mid;
                    case 0:
                        return mid;
                    case 1:
                        int rmid = fun(a, mid + 1, end, target, 1);
                        return rmid >= 0 ? rmid : mid;
                }
            }
        }
    }
}
