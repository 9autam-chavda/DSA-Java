class Solution {
    public int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        for(int i=0; i<memo.length; i++) {
            memo[i] = -1;
        }
        return solve(n, 0);
    }

    public int solve(int n, int idx) {
        if(idx > n) {
            return 0;
        }
        if(idx == n) {
            return 1;
        }

        if(memo[idx] != -1) {
            return memo[idx];
        }

        int one = solve(n, idx+1);
        int two = solve(n, idx+2);

        memo[idx] = one + two;

        return memo[idx];
    }
}