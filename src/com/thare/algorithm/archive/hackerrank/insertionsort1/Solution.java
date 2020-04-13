package com.thare.algorithm.archive.hackerrank.insertionsort1;

import java.util.*;

public class Solution {


    public static void insertIntoSorted(int[] ar) {
        int i, j, t;
        for (i = 1; i < ar.length; ++i) {
            t = ar[i];
            for (j = i - 1; j >= 0; --j) {
                if (ar[j] > t) {
                    ar[j + 1] = ar[j];
                    printArray(ar);
                } else {
                    ar[j + 1] = t;
                    if (j + 1 != i) {
                        printArray(ar);
                    }
                    break;
                }
            }
            if (j == -1) {
                ar[j + 1] = t;
                printArray(ar);
            }
        }
    }

    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }


}


