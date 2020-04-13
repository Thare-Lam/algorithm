package com.thare.algorithm.archive.hackerrank.big_sorting;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });
        for(int i=0; i < n; i++){
            pq.add(in.next());
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

}
