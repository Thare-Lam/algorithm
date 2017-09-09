package company.netease._20170812._02;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = in.nextInt();
            }
            System.out.println(process(arr, n));
        }
    }

    private static String process(int[] arr, int n) {
        if (n <= 2) {
            return "Possible";
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : arr) {
            pq.add(a);
        }
        int last = pq.poll();
        int cur = pq.poll();
        int lastGap = cur - last;
        last = cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            if (cur - last != lastGap) {
                return "Impossible";
            }
            last = cur;
        }
        return "Possible";
    }

}
