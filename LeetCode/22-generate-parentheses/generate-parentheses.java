class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        dfs(0, 0, "", n, result);

        return result;
    }

    private void dfs(int left, int right, String s,
                     int n, List<String> result) {

        if (s.length() == n * 2) {
            result.add(s);
            return;
        }

        if (left < n) {
            dfs(left + 1, right, s + "(", n, result);
        }

        if (right < left) {
            dfs(left, right + 1, s + ")", n, result);
        }
    }
}