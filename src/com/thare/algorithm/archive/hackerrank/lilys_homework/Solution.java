package com.thare.algorithm.archive.hackerrank.lilys_homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = in.nextInt();
        }
        int[] arrSorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrSorted);
        int res = Math.min(cal(reverse(arr), arrSorted), cal(arr, arrSorted));
        System.out.println(res);
    }

    private static int cal(int[] arr, int[] arrSorted) {
        int i, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (i = 0; i < arr.length; ++i) {
            map.put(arr[i], i);
        }
        for (i = 0; i < arr.length; ++i) {
            if (arr[i] != arrSorted[i]) {
                ++count;
                map.put(arr[i], map.get(arrSorted[i]));
                arr[map.get(arrSorted[i])] = arr[i];
            }
        }
        return count;
    }

    private static int[] reverse(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            res[len - 1- i] = arr[i];
        }
        return res;
    }
}
