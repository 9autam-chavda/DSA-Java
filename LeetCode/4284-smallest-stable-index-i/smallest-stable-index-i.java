class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[][] mn = new int[n][2];

        mn[0][0] = nums[0];
        for(int i=1; i<n; i++) {
            mn[i][0] = Math.max(mn[i-1][0], nums[i]);
        }

        mn[n-1][1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            mn[i][1] = Math.min(mn[i+1][1], nums[i]);
        }

        int small = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int val = mn[i][0] - mn[i][1];
            if(val <= k) {
                small = Math.min(small, i);
            }
        }

        return small==Integer.MAX_VALUE ? -1:small;
    }
}