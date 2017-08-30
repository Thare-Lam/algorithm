package base.bubble_sort;

import utils.TestUtils;

public class Main {

    public static void bubbleSort(int[] arr) {
        boolean noSwap = false;
        for (int i = arr.length - 1; i > 0 && !noSwap; --i) {
            noSwap = true;
            for (int j = 0; j < i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    noSwap = false;
                }
            }
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = TestUtils.SORT_ARRAY_INT;
        bubbleSort(arr);
        TestUtils.printArray(arr);
    }

}
