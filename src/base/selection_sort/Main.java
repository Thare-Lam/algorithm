package base.selection_sort;

import utils.TestUtils;

public class Main {

    private static void selectionSort(int arr[]) {
        int max;
        int index;
        for (int i = arr.length - 1; i > 0; --i) {
            max = arr[0];
            index = 0;
            for (int j = 1; j <= i; ++j) {
                if (arr[j] > max) {
                    max = arr[j];
                    index = j;
                }
            }
            swap(arr, index, i);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = TestUtils.SORT_ARRAY_INT;
        selectionSort(arr);
        TestUtils.printArray(arr);
    }

}
