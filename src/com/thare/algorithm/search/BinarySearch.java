package com.thare.algorithm.search;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(TestUtil.INT_ARRAY_SORTED, 0));
    }

    public static int search(int[] array, int value) {
        int l = 0, r = array.length, m;
        while (l < r) {
            m = l + ((r - l) >> 2);
            if (array[m] >= value) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        // 如果没找到，返回应该插入的位置取反并减1（考虑0的情况）
        if (array[l] != value) {
            return - l - 1;
        }
        return l;
    }

}
