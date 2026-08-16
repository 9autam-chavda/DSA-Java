package LeetCode;

public class p1 {

    public int[] twoSum(int[] nums, int target) {
        int one = 0; 
        int two = 0;
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if ((nums[i]+nums[j]) == target ) {
                    return new int [] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        p1 s = new p1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = s.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}

