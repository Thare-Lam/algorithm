package leetcode._016_3sum_closest;

import java.util.*;

public class Solution {

    public int threeSumClosest(int[] numbers, int target) {
        Arrays.sort(numbers);
        int i, j, k, sum, res = 0, gap, minGap = Integer.MAX_VALUE;
        for (i = 0; i < numbers.length - 2; ++i) {
            j = i + 1;
            k = numbers.length - 1;
            while (true) {
                if (j >= k) {
                    break;
                }
                sum = numbers[i] + numbers[j] + numbers[k];
                if (sum == target) {
                    return target;
                } else {
                    gap = Math.abs(sum - target);
                    if (gap < minGap) {
                        minGap = gap;
                        res = sum;
                    }
                    if (sum < target) {
                        ++j;
                    } else {
                        --k;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{0, 1, 2}, 3));
    }
}
