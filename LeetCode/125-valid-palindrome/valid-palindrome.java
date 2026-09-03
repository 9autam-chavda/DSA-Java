class Solution {
    public boolean isPalindrome(String s) {
        String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = result.length();
        int j = n-1;
        for(int i=0; i<n/2; i++) {
            if(result.charAt(i) != result.charAt(j)) {
                return false;
            }
            j--;
        }

        return true;
    }
}