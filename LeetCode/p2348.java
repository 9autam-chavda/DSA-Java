package LeetCode;

public class p2348 {

    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long current = 0;

        for (int num : nums) {
            if (num == 0) {
                current++;       // extend zero block
                count += current; // add all new subarrays ending here
            } else {
                current = 0;     // reset if non-zero
            }
        }

        return count;
    }
}
