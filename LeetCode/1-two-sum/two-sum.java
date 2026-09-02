class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
        }

        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int num = target - n; 
            List<Integer> indices = map.get(num);

            if (indices == null) {
                continue;
            }
            
            if (num == n) {
                if (indices.size() >= 2) { 
                    ans[0] = indices.get(0);
                    ans[1] = indices.get(1);
                    break;
                }
            }
            else {
                ans[0] = i;
                ans[1] = indices.get(0);
                break;
            }
        }

        return ans;
    }
}
