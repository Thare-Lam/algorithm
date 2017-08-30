package utils;

public class TestUtils {

    public static int[] SORT_ARRAY_INT = new int[]{6, 18, 3, 5, 17, 7, 1, 15,  20, 11, 10, 8, 2, 14, 4, 12, 9, 13, 19, 16};

    public static int[] SEARCH_ARRAY_INT = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public static String[][] SUB_STRING_ARRAY = new String[][]{new String[]{"abcabcabc", "cabc"},
            new String[]{"abcd", "bce"}, new String[]{"aaaaabcd", "aab"}};

    public static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
