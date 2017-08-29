package lintcode.majority_number_iii;

import java.util.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxCount = 0;
        int result = 0;
        for (int i : nums) {
            if (set.contains(i)) {
                map.put(i, map.get(i) + 1);
            } else if (k > 0) {
                set.add(i);
                map.put(i, 1);
                --k;
            } else {
                Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
                for (Map.Entry<Integer, Integer> entry : entrySet) {
                    if (entry.getValue() > 1) {
                        entry.setValue(entry.getValue() - 1);
                    } else {
                        set.remove(entry.getKey());
                        ++k;
                    }
                }
            }
        }
        map.clear();
        for (int i : nums) {
            if (set.contains(i)) {
                if (map.get(i) == null) {
                    map.put(i, 1);
                } else {
                    map.put(i, map.get(i) + 1);
                }
                if (map.get(i) > maxCount) {
                    maxCount = map.get(i);
                    result = i;
                }
            }
        }
        return result;
    }
}
