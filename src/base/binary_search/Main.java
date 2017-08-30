package base.binary_search;

public class Main {

    public static int binarySearch(int arr[], int k) {
        return binarySearch(arr, 0, arr.length, k);
    }

    public static int binarySearch(int arr[], int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if (arr[mid] < k) {
            return binarySearch(arr, mid + 1, end, k);
        } else if (arr[mid] > k) {
            return binarySearch(arr, start, mid - 1, k);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(binarySearch(arr, arr[i]) == i);
        }
    }

}
