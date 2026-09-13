class Solution {
    int[] memo; 

    public int rob(int[] nums) {
        memo = new int[nums.length];
        for(int i=0; i<memo.length; i++) {
            memo[i] = -1;
        } 
        
        return solve(nums, 0);
    }

    public int solve(int[] nums, int idx) {
        if (idx >= nums.length) {
            return 0;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        int skip = solve(nums, idx + 1);

        int rob = nums[idx] + solve(nums, idx + 2);

        memo[idx] = Math.max(skip, rob);
        
        return memo[idx];
    }
}
