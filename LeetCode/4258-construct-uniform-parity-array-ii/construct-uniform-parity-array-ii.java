class Solution {
    public boolean uniformArray(int[] nums1) {
        int sm = Integer.MAX_VALUE;
        for(int n : nums1) {
            sm = Math.min(sm, n);
        }

        if(sm % 2 == 1) {
            return true;
        }

        for(int n:nums1) {
            if(n%2 == 1) {
                return false;
            }
        }

        return true;
    }
}