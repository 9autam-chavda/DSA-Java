class Solution {

    private int digitSum(int x) {

        int sum = 0;

        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }

    public int smallestIndex(int[] nums) {

        int ans = -1;

        for (int i = 0; i < nums.length; i++) {

            if (i == digitSum(nums[i])) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}