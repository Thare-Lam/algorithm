package lintcode._3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i, j, k, sum, l = 0;
        for (i = 0; i < numbers.length - 2; ++i) {
            if (i > 0 && numbers[i] == l) {
                continue;
            }
            l = numbers[i];
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
                    if (!result.isEmpty()) {
                        List<Integer> last = result.get(result.size() - 1);
                        if (last.get(0) - numbers[i] != 0
                                || last.get(1) - numbers[j] != 0
                                || last.get(2) - numbers[k] != 0) {
                            result.add(Arrays.asList(numbers[i], numbers[j], numbers[k]));
                        }
                    } else {
                        result.add(Arrays.asList(numbers[i], numbers[j], numbers[k]));
                    }
                    ++j;
                    --k;
                } else {
                    --k;
                }
            }
        }
        return result;
    }

}
