class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int ans = 0;  
        int count = 0;  

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                count += 1;
            } else {
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++; 
                } else {
                    ans += 1;
                }

                if (count > 0) {
                    count -= 1; 
                } else {
                    ans += 1;  
                }
            }
        }

        ans += count * 2;
        
        return ans;
    }
}
