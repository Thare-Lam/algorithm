package base.quick_sort;

import java.util.Random;

public class Main {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < 0 || start >= end) {
            return;
        }
        int mid = getP(arr, start, end);
        quickSort(arr, start, mid - 1);
        quickSort(arr, mid + 1, end);
    }

    private static int getP(int[] arr, int start, int end) {
        random(arr, start, end, end);
        int i, k = start - 1;
        int pn = arr[end];
        for (i = start; i < end; ++i) {
            if (arr[i] < pn) {
                swap(arr, ++k, i);
            }
        }
        swap(arr, ++k, end);
        return k;
    }

    private static int getP2(int[] arr, int start, int end) {
        random(arr, start, end, start);
        int i = start;
        int j = end;
        int pn = arr[start];
        while (i < j) {
            while (i < j && arr[j] >= pn) {
                --j;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] <= pn) {
                ++i;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = pn;
        return i;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void random(int[] arr, int x, int y, int z) {
        Random random = new Random();
        int p = x + random.nextInt(y - x + 1);
        swap(arr, p, z);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 1, 10, 0, 4, 99, 32, 23, 2};
        int n = 10;
        while (n-- > 0) {
            quickSort(arr);
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

}
