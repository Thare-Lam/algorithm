package nowcoder.test2017.fc05f68c5f47438db54c6923ef23cf4a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int i;
            long count = 0;
            int[] arr = new int[n];
            for (i = 0; i < n; ++i) {
                arr[i] = scanner.nextInt();
            }
            TrieTree tree = buildTrieTree(arr);
            for (i = 0; i < n; ++i ) {
                count += count(tree, arr[i], m, 30);
            }
            System.out.println(count / 2);
        }
    }


    private static class TrieTree {
        TrieTree[] next = new TrieTree[2];
        long count = 0;
    }

    private static TrieTree buildTrieTree(int[] arr) {
        TrieTree tree = new TrieTree();
        TrieTree cur;
        int b;
        for (int a : arr) {
            cur = tree;
            for (int i = 30; i >= 0; --i) {
                b = (a >> i) & 1;
                if (cur.next[b] == null) {
                    cur.next[b] = new TrieTree();
                }
                ++cur.next[b].count;
                cur = cur.next[b];
            }
        }
        return tree;
    }

    private static long count(TrieTree tree, int a, int m, int k) {
        if (tree == null || k < 0) {
            return 0;
        }
        int da = (a >> k) & 1;
        int dm = (m >> k) & 1;
        if (dm == 1) {
            if (da == 1) {
                return count(tree.next[0], a, m, k - 1);
            } else {
                return count(tree.next[1], a, m, k - 1);
            }
        } else {
            if (da == 1) {
                return count(tree.next[1], a, m, k - 1) + (tree.next[0] == null ? 0 : tree.next[0].count);
            } else {
                return count(tree.next[0], a, m, k - 1) + (tree.next[1] == null ? 0 : tree.next[1].count);
            }
        }
    }
}
