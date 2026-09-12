class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubset(nums, new ArrayList<>(), ans, 0);
        return ans;
    }

    public void findSubset(int[] nums, List<Integer> sub, List<List<Integer>> ans, int idx) {
        if(idx == nums.length){
            ans.add(new ArrayList<>(sub));
            return;
        }

        
        findSubset (nums, sub, ans, idx+1);

        sub.add(nums[idx]);
        findSubset (nums, sub, ans, idx+1);
        sub.remove(sub.size()-1);
        
    }
}