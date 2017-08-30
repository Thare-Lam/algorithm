package base.bubble_sort;

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
        int[] arr = new int[]{5, 9, 1, 10, 0, 4, 99, 32, 23, 2};
        int n = 10;
        while (n-- > 0) {
            bubbleSort(arr);
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
