package com.thare.algorithm.archive.company.pinduoduo._20170801._04;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int sx = 0, sy = 0, ex = 0, ey = 0;
            char[][] map = new char[n][];
            for (int i = 0; i < n; ++i) {
                map[i] = in.next().toCharArray();
                for (int j = 0; j < m; ++j) {
                    if (map[i][j] == '2') {
                        sx = i;
                        sy = j;
                    } else if (map[i][j] == '3') {
                        ex = i;
                        ey = j;
                    }
                }
            }
            System.out.println(bfs(map, n, m, sx, sy, ex, ey));
        }
    }

    private static int bfs(char[][] map, int n, int m, int sx, int sy, int ex, int ey) {
        int[] gx = new int[]{0, 0, 1, -1};
        int[] gy = new int[]{1, -1, 0, 0};
        int[][][] res = new int[n][m][1023];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                Arrays.fill(res[i][j], -1);
            }
        }
        res[sx][sy][0] = 0;
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(sx, sy, 0);
        queue.add(start);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == ex && cur.y == ey) {
                return res[cur.x][cur.y][cur.k];
            }
            for (int i = 0; i < 4; ++i) {
                int x = cur.x + gx[i];
                int y = cur.y + gy[i];
                if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] == '0') {
                    continue;
                }
                Node temp = new Node(x, y, cur.k);
                if (map[x][y] >= 'a' && map[x][y] <= 'z') {
                    temp.k |= (1 << (map[x][y] - 'a'));
                } else if (map[x][y] >= 'A' && map[x][y] <= 'Z') {
                    if ((temp.k & (1 << (map[x][y] - 'A'))) == 0) {
                        continue;
                    }
                }
                if (res[temp.x][temp.y][temp.k] == -1 || res[temp.x][temp.y][temp.k] > res[cur.x][cur.y][cur.k] + 1) {
                    res[temp.x][temp.y][temp.k] = res[cur.x][cur.y][cur.k] + 1;
                    queue.add(temp);
                }
            }
        }
        return -1;
    }

    private static class Node {

        int x;

        int y;

        int k;

        Node(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

}
