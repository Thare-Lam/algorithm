package com.thare.algorithm.archive.nowcoder.test2017.d2cced737eb54a3aa550f53bb3cc19d0;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] desk2 = new int[n];
            int i, man, money;
            long max = 0;
            for (i = 0; i < n; ++i) {
                desk2[i] = scanner.nextInt();
            }
            Arrays.sort(desk2);
            ArrayList<Integer> desk = new ArrayList<>(desk2.length);
            for (i = 0; i < desk2.length; ++i) {
                desk.add(desk2[i]);
            }
            int maxDesk = desk.get(desk.size() - 1);
            PriorityQueue<Group> queue = new PriorityQueue<>(m);
            for (i = 0; i < m; ++i) {
                man = scanner.nextInt();
                money = scanner.nextInt();
                if (man <= maxDesk) {
                    queue.add(new Group(man, money));
                }
            }
            int index;
            while (!queue.isEmpty() && desk.size() > 0) {
                Group g = queue.poll();
                index = findMinIndex(desk, 0, desk.size() - 1, g.man);
                if (index >= 0) {
                    max += g.money;
                    desk.remove(index);
                }
            }

            System.out.println(max);
        }
    }

    private static int findMinIndex(ArrayList<Integer> desk, int start, int end, int man) {
        if (start < 0 || end == desk.size()) {
            return -1;
        }
        if (start == end) {
            if (desk.get(start) >= man) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = start + (end - start) / 2;
        if (desk.get(mid) > man) {
            if (mid > 0 && desk.get(mid - 1) < man) {
                return mid;
            } else if (mid == 0) {
                return 0;
            } else {
                return findMinIndex(desk, start, mid - 1, man);
            }
        } else if (desk.get(mid) < man) {
            if (mid < desk.size() - 1 && desk.get(mid + 1) >= man) {
                return mid + 1;
            } else if (mid == desk.size() - 1) {
                return -1;
            } else {
                return findMinIndex(desk, mid + 1, end, man);
            }
        } else {
            return mid;
        }
    }

    private static class Group implements Comparable<Group> {
        int man;
        int money;

        public Group(int man, int money) {
            this.man = man;
            this.money = money;
        }

        @Override
        public int compareTo(Group g) {
            int gap = g.money - this.money;
            if (gap > 0) {
                return 1;
            } else if (gap < 0) {
                return -1;
            }
            return 0;
        }
    }
}
