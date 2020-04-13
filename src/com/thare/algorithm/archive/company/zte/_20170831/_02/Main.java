package com.thare.algorithm.archive.company.zte._20170831._02;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        System.out.println(
                process(8, 4, new int[]{2, 3, 5, 6}, new int[][]{
                        new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 4}, new int[]{2, 5}, new int[]{3, 6},
                        new int[]{3, 7}, new int[]{6, 8}
                })
        );
    }

    private static int process(int numNodes, int numOfApples, int[] appleList, int[][] edges) {
        int[] newAppleList = new int[numNodes];
        for (int i : appleList) {
            newAppleList[i - 1] = 1;
        }
        int[] res = f(newAppleList, edges, 0, 1);
        return Math.max(res[0], res[1]);
    }


    private static int[] f(int[] appleList, int[][] edges, int edgeIndex, int parent) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2.compareTo(o1)));
        int max = 0;
        for (int i = edgeIndex; i < edges.length; ++i) {
            if (edges[i][0] == parent) {
                int[] subRes = f(appleList, edges, i, edges[i][1]);
                pq.add(subRes[0]);
                max = Math.max(max, subRes[1]);
            }
        }
        int[] res = new int[2];
        Integer l1 = pq.poll();
        Integer l2 = pq.poll();
        res[0] = appleList[parent - 1] + (l1 != null ? l1 : 0);
        res[1] = Math.max(max,
                appleList[parent - 1] + (l1 != null ? l1 : 0) + (l2 != null ? l2 : 0));
        return res;
    }

}
