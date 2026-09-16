public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n + 1];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return helper(0, -1, nums, memo);
    }
    
    private int helper(int i, int prevIdx, int[] nums, int[][] memo) {
        if (i == nums.length) {
            return 0;
        }
        
        if (memo[i][prevIdx + 1] != -1) {
            return memo[i][prevIdx + 1];
        }
        
        int skip = helper(i + 1, prevIdx, nums, memo);
        
        int take = 0;
        if (prevIdx == -1 || nums[i] > nums[prevIdx]) {
            take = 1 + helper(i + 1, i, nums, memo);
        }
        
        memo[i][prevIdx + 1] = Math.max(skip, take);
        return memo[i][prevIdx + 1];
    }
}
