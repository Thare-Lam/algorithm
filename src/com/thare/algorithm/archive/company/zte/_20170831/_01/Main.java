package com.thare.algorithm.archive.company.zte._20170831._01;

public class Main {

    public static void main(String[] args) {
        System.out.println(process(3, 1, new int[]{-1, 2, 3, 2}, new int[][]{
                new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 4}
        }));
    }

    public static int process(int numNodes, int rootNodes, int[] values, int[][] edges) {
        return f(values, edges, 0, 1, values[rootNodes - 1]);
    }

    private static int f(int[] values, int[][] edges, int edgeIdnex, int parent, int curValue) {
        int[] son = new int[2];
        int[] sonIndex = new int[2];
        int index = 0;
        for (int i = edgeIdnex; i < edges.length && index < 2; ++i) {
            if (edges[i][0] == parent) {
                son[index] = edges[i][1];
                sonIndex[index] = i;
                ++index;
            }
        }
        if (index == 0) {
            return curValue;
        } else if (index == 1) {
            return f(values, edges, sonIndex[0], son[0], curValue * values[son[0] - 1]);
        } else {
            return Math.max(f(values, edges, sonIndex[0], son[0], curValue * values[son[0] - 1]),
                    f(values, edges, sonIndex[1], son[1], curValue * values[son[1] - 1]));
        }
    }

}
