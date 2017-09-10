package leetcode._055_jump_game;

class Solution {

    public boolean canJump(int[] nums) {
        int i = 0, reach = 0, n = nums.length;
        while (i < n && i <= reach) {
            reach = Math.max(reach, i + nums[i++]);
        }
        return i == n;
    }

}