class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i=0; i<dp.length; i++) {
            dp[i] = -2;
        }
        
        int result = solve(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int solve(int[] coins, int remainingAmount, int[] dp) {
        if (remainingAmount == 0) return 0;
        if (remainingAmount < 0) return Integer.MAX_VALUE;
        
        if (dp[remainingAmount] != -2) return dp[remainingAmount];

        int minCoins = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int res = solve(coins, remainingAmount - coins[i], dp);
            
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }

        dp[remainingAmount] = minCoins;
        return minCoins;
    }
}
