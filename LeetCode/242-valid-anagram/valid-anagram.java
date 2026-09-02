class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            counts[ch] += 1; 
        }

        for (int i = 0; i < t.length(); i++) {
            int ch = t.charAt(i) - 'a'; 
            counts[ch] -= 1;
        }

        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
