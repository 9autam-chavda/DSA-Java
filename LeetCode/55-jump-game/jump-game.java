class Solution {
    private Integer[] memo; 

    public boolean canJump(int[] nums) {
        memo = new Integer[nums.length];
        return jump(nums, 0);
    }

    private boolean jump(int[] nums, int idx) {
        if (idx >= nums.length - 1) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx] == 1;
        }

        int maxJump = nums[idx];

        for (int i = 1; i <= maxJump; i++) {
            if (jump(nums, idx + i)) {
                memo[idx] = 1; 
                return true;
            }
        }

        memo[idx] = 0; 
        return false;
    }
}
