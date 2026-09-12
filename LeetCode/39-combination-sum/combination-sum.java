class Solution {
    private List<List<Integer>> ans; 

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        solve(candidates, target, new ArrayList<>(), 0, 0); 
        return ans;
    }

    private void solve(int[] candidates, int target, List<Integer> list, int sum, int i) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (i == candidates.length || sum > target) {
            return;
        }

        list.add(candidates[i]);
        solve(candidates, target, list, sum + candidates[i], i);
        
        list.remove(list.size() - 1);

        solve(candidates, target, list, sum, i + 1);
    }
}
