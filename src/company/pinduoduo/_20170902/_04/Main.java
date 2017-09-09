package company.pinduoduo._20170902._04;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
            }
            System.out.println(process(n, m, k, l, r, a));
        }
    }

    private static long process(int n, int m, int k, int l, int r, int[] a) {
        List<ArrayList<Integer>> is = getIs(a, k, l, r);
        return c(m, k) * p((r - l) + 1, m - k) * is.size() % 10007;
    }

    private static List<ArrayList<Integer>> getIs(int[] a, int k, int l, int r) {
        List<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= a.length - k; ++i) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(a[i]);
            f(a, i, k - 1, l, r, list);
            if (list.size() == k) {
                res.add(list);
            }
        }
        return res;
    }

    private static void f(int[] a, int last, int k, int l, int r, ArrayList<Integer> arr) {
        if (k == 0) {
            return;
        }
        if (a.length - last < k) {
            arr.clear();
            return;
        }
        int min = a[last];
        for (int i = last + 1; i < a.length; ++i) {
            if (a[i] > min && a[i] >= l && a[i] <= r) {
                arr.add(a[i]);
                f(a, i, k - 1, l, r, arr);
            }
        }
    }

    private static long c(int a, int b) {
        long i, n = 1, m = 1;
        for (i = a; i > a - b; --i) {
            n *= i;
        }
        for (i = 1; i <= b; ++i) {
            m *= i;
        }
        return (n / m) % 10007;
    }

    private static long p(int a, int b) {
        int res = 1;
        for (int i = 0; i < b; ++i) {
            res *= a;
            res %= 10007;
        }
        return res;
    }
}
