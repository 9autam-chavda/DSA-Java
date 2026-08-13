package practice;

public class Lsum {
    public int[] twoSum(int[] nums, int target) {
        int one = 0; 
        int two =0;
        for (int i=0; i<nums.length; i++) {
            for (int j=1; j<nums.length; j++) {
                if ((nums[i]+nums[j]) == target ) {
                    one = nums[i];
                    two = nums[j];
                }
            }
        }

        int [] ans = new int[2];  
        ans[0] = one;
        ans[1] = two;

        return ans;  
    }
}
