package LeetCode;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> Charset = new HashSet<>();

        int maxLength = 0;
        int left = 0;

        for(int right=0; right < s.length(); right++) {

            while(Charset.contains(s.charAt(right))) {
                Charset.remove(s.charAt(left));
                left++;
            }

            Charset.add(s.charAt(right));
            maxLength = Math.max(maxLength, right-left+1);
        }   
        return maxLength;   
    }
}
