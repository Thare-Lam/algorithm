package nowcoder.coding_interviews._390da4f7a00f44bea7c2f3d19491311b;

import java.util.ArrayList;

public class Solution {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int[] res = new int[2];
        boolean flag = false;
        for (int i = 0, j = array.length - 1; i < j;) {
            if (array[i] + array[j] == sum) {
                if (!flag || array[i] * array[j] < res[0] * res[1]) {
                    res[0] = array[i];
                    res[1] = array[j];
                    flag = true;
                }
                ++i;
                --j;
            } else if (array[i] + array[j] < sum) {
                ++i;
            } else {
                --j;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (flag) {
            result.add(res[0]);
            result.add(res[1]);
        }
        return result;
    }

}
