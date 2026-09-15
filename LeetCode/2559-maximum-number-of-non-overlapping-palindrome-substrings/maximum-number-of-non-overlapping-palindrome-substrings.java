class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + k - 1; j < Math.min(n, i + k + 1); j++) {
                
                if (isPalindrome(s, i, j)) {
                    ans += 1;
                    i = j; 
                    break; 
                }
            }
        }

        return ans;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (right > left) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1; 
        }
        return true;
    }
}
