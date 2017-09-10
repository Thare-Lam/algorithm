package leetcode._015_3sum;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i, j, k, sum;
        for (i = 0; i < numbers.length - 2; ++i) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            j = i + 1;
            k = numbers.length - 1;
            while (true) {
                if (j >= k) {
                    break;
                }
                sum = numbers[i] + numbers[j] + numbers[k];
                if (sum < 0) {
                    ++j;
                } else if (sum == 0) {
                    while (j < k && numbers[j] == numbers[j + 1]) {
                        ++j;
                    }
                    while (j < k && numbers[k] == numbers[k - 1]) {
                        --k;
                    }
                    result.add(Arrays.asList(numbers[i], numbers[j], numbers[k]));
                    ++j;
                    --k;
                } else {
                    --k;
                }
            }
        }
        return result;
    }

    private boolean listEquals(List<List<Integer>> lists, int a, int b, int c) {
        if (lists.isEmpty()) {
            return false;
        }
        List<Integer> list = lists.get(lists.size() - 1);
        return list.get(0) == a && list.get(1) == b && list.get(2) == c;
    }

}
