package company.netease._20180812._07;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = in.nextInt();
            }
            System.out.println(maxArr(arr));
        }
    }

    private static int maxArr(int[] arr) {
        Arrays.sort(arr);
        int res = arr[arr.length - 1] - arr[0];
        int i = 1;
        int j = arr.length - 2;
        while (i < j) {
            res += arr[j + 1] - arr[i];
            res += arr[j] - arr[i - 1];
            ++i;
            --j;
        }
        if (i == j) {
            res += Math.max(arr[j] - arr[j - 1], arr[j + 1] - arr[j]);
        }
        return res;
    }

}
