class Solution {

    int[][] memo = new int[100][40004];

    public int rob(int[] nums) {

        for(int i=0; i<memo.length; i++) {
            for(int j=0; j<memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(nums, 0, 0);
    }

    public int solve(int[] nums, int idx, int count) {
        if(idx >= nums.length) {
            return count;
        }

        if(memo[idx][count] != -1) {
            return memo[idx][count];
        }

        int skip = solve(nums, idx+1, count);
        int rob = solve(nums, idx+2, count+nums[idx]);

        memo[idx][count] = Math.max(skip, rob);
        
        return memo[idx][count];
    }
}