package lintcode.create_maximum_number;

import java.util.*;

// todo
public class Solution {
    /**
     * @param nums1 an integer array of length m with digits 0-9
     * @param nums2 an integer array of length n with digits 0-9
     * @param k an integer and k <= m + n
     * @return an integer array
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        Map<Integer, List<Integer>> map1 = getIndexMap(nums1);
        Map<Integer, List<Integer>> map2 = getIndexMap(nums2);
        int s1 = 0;
        int s2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int e1 = len1 - 1;
        int e2 = len2 - 1;
        int last1 = -1;
        int last2 = -1;
        int count;
        int index = 0;
        boolean f1;
        boolean f2;
        while (index < k) {
            count = len1 - s1 + len2 - s2 + index;
            if (count == k) {
                addAll(res, index, nums1, s1, nums2, s2);
                break;
            } else if (count > k){
                s1 = findMaxIndex(map1, s1, e1);
                s2 = findMaxIndex(map2, s2, e2);
                if (s1 == -1) {
                    addAllOne(res, index, k, nums2, s2, last2, map2);
                    break;
                } else if (s2 == -1) {
                    addAllOne(res, index, k, nums1, s1, last1, map1);
                    break;
                }
                count = len1 - s1 + len2 - s2 + index;
                if (count > k) {
                    if (nums1[s1] > nums2[s2]) {
                        last1 = s1;
                        res[index++] = nums1[s1++];
                        e1 = Math.max(e1, s1);
                    } else if (nums1[s1] < nums2[s2]) {
                        last2 = s2;
                        res[index++] = nums2[s2++];
                        e2 = Math.max(e2, s2);
                    } else {
                        if (len1 - s1 >= len2 - s2) {
                            last1 = s1;
                            res[index++] = nums1[s1++];
                        } else {
                            last2 = s2;
                            res[index++] = nums2[s2++];
                        }
                    }
                } else if (count < k) {
                    f1 = count + s1 - last1 - 1 >= k;
                    f2 = count + s2 - last2 - 1 >= k;
                    if (nums1[s1] > nums2[s2] && f2) {
                        s2 -= k - count;
                    } else if (nums1[s1] < nums2[s2] && f1) {
                        s1 -= k - count;
                    } else {
                        if (f1 && f2) {
                            if (compareArr(nums1, s1 - k + count, s1, nums2, s2 - k + count, s2) >= 0) {
                                s1 -= k - count;
                            } else {
                                s2 -= k - count;
                            }
                        } else if (f1) {
                            e1 = s1 - 1;
                            s1 = last1 + 1;
                        } else if (f2){
                            e2 = s2 - 1;
                            s2 = last2 + 1;
                        } else {
                            while (len1 - s1 + len2 - s2 + index < k) {
                                e1 = s1 - 1;
                                e2 = s2 - 1;
                                s1 = findMaxIndex(map1, last1 + 1, e1);
                                s2 = findMaxIndex(map2, last2 + 1, e2);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private Map<Integer, List<Integer>> getIndexMap(int[] num) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list;
        for (int i = 0; i < num.length; ++i) {
            if (map.containsKey(num[i])) {
                list = map.get(num[i]);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(num[i], list);
        }
        int size = map.keySet().size();
        int[] keyArr = new int[size];
        int i = 0;
        for (int key : map.keySet()) {
            keyArr[i++] = key;
        }
        Arrays.sort(keyArr);
        List<Integer> keyList = new ArrayList<>(size);
        for (i = size - 1; i >=0; --i) {
            keyList.add(keyArr[i]);
        }
        map.put(-1, keyList);
        return map;
    }

    private int findMaxIndex(Map<Integer, List<Integer>> map, int start, int end) {
        if (map.keySet().size() < 2) {
            return -1;
        }
        if (start >= end) {
            return start;
        }
        List<Integer> list;
        for (int key : map.get(-1)) {
            list = map.get(key);
            for (int index : list) {
                if (index >= start && index <= end) {
                    return index;
                }
            }
        }
        return -1;
    }

    private void addAll(int[] arr, int index, int[] num1, int s1, int[] num2, int s2) {
        int len1 = num1.length;
        int len2 = num2.length;
        while (s1 < len1 && s2 < len2) {
            if (num1[s1] > num2[s2]) {
                arr[index++] = num1[s1++];
            } else if (num1[s1] < num2[s2]) {
                arr[index++] = num2[s2++];
            } else {
                if (compareArr(num1, s1, len1, num2, s2, len2) >= 0) {
                    arr[index++] = num1[s1++];
                } else {
                    arr[index++] = num2[s2++];
                }
            }
        }
        while (s1 < len1) {
            arr[index++] = num1[s1++];
        }
        while (s2 < len2) {
            arr[index++] = num2[s2++];
        }
    }

    private void addAllOne(int[] arr, int index, int k, int[] num, int s, int last, Map<Integer, List<Integer>> map) {
        int len = num.length;
        int e = len - 1;
        int count;
        while (index < k) {
            s = findMaxIndex(map, s, e);
            count = len - s + index;
            if (count < k) {
                e = s - 1;
                s = last + 1;
            } else if (count > k) {
                last = s;
                arr[index++] = num[s++];
            } else {
                while (s < len) {
                    arr[index++] = num[s++];
                }
                break;
            }
        }
    }

    private int compareArr(int[] num1, int s1, int e1, int[] num2, int s2, int e2) {
        int i = s1;
        int j = s2;
        while (i < e1 && j < e2) {
            if (num1[i] == num2[j]) {
                ++i;
                ++j;
            } else {
                return num1[i] - num2[j];
            }
        }
        if (i == num1.length) {
            return compareArr(num1, s1, e1, num2, j, e2);
        } else {
            return compareArr(num1, i, e1, num2, s2, e2);
        }
    }

    public static void main(String[] args) {
        int[] ans = new Solution().maxNumber(new int[]{1,5,8,1,4,0,8,5,0,7,0,5,7,6,0,5,5,2,4,3,6,4,6,6,3,8,1,1,3,1,3,5,4,3,9,5,0,3,8,1,4,9,8,8,3,4,6,2,5,4,1,1,4,6,5,2,3,6,3,5,4,3,0,7,2,5,1,5,3,3,8,2,2,7,6,7,5,9,1,2},
                new int[]{7,8,5,8,0,1,1,6,1,7,6,9,6,6,0,8,5,8,6,3,4,0,4,6,7,8,7,7,7,5,7,2,5,2,1,9,5,9,3,7,3,9,9,3,1,4,3,3,9,7,1,4,4,1,4,0,2,3,1,3,2,0,2,4,0,9,2,0,1,3,9,1,2,2,6,6,9,3,6,0},
                80);
        for (int i : ans) {
            System.out.print(i);
        }
        System.out.println();
    }
}
