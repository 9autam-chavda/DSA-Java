class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        Boolean[][] memo = new Boolean[nums.length][target + 1];

        return solve(nums, target, 0, 0, memo);
    }

    public boolean solve(int[] nums, int target, int currentSum, int i, Boolean[][] memo) {
        if (currentSum == target) {
            return true;
        }

        if (i >= nums.length || currentSum > target) {
            return false;
        }

        if (memo[i][currentSum] != null) {
            return memo[i][currentSum];
        }

        boolean take = solve(nums, target, currentSum + nums[i], i + 1, memo);
        
        boolean skip = solve(nums, target, currentSum, i + 1, memo);

        memo[i][currentSum] = take || skip;
        return memo[i][currentSum];
    }
}
