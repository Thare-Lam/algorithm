package leetcode._368_largest_divisible_subset;

import java.util.*;

public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        int maxSize = 0, num = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list, temp;
        for (int i = 0, len = nums.length; i < len; ++i) {
            list = new LinkedList<>();
            map.put(nums[i], list);
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0) {
                    temp = map.get(nums[j]);
                    if (temp.size() >= list.size()) {
                        list.clear();
                        list.addAll(temp);
                    }
                }
            }
            list.add(nums[i]);
            if (list.size() > maxSize) {
                maxSize = list.size();
                num = nums[i];
            }
        }
        return map.get(num);
    }

}
