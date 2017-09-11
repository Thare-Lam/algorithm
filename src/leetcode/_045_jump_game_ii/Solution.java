package leetcode._045_jump_game_ii;

public class Solution {

    public int jump(int[] nums) {
        int i = 0, reach = 0, maxReach = 0, step = 0, n = nums.length;
        while (maxReach < n - 1) {
            while (i <= reach) {
                maxReach = Math.max(maxReach, i + nums[i++]);
            }
            reach = maxReach;
            ++step;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2,3,1,1,4}));
    }

}
