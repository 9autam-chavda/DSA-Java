class Solution {
    public String minWindow(String s, String t) {
        int[] tCount = new int[128];
        int[] sCount = new int[128];
        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int startIdx = 0; 

        for(int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }

        for(int right = 0; right < s.length(); right++) {
            sCount[s.charAt(right)]++;
            
            while(checkSame(tCount, sCount) && left <= right) {
                int currentWindowLen = right - left + 1;
                if (currentWindowLen < minLen) {
                    minLen = currentWindowLen;
                    startIdx = left; 
                }
                
                sCount[s.charAt(left)]--;
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIdx, startIdx + minLen);
    }

    public boolean checkSame(int[] tCount, int[] sCount) {
        for(int i = 0; i < 128; i++) {
            if(tCount[i] != 0 && sCount[i] < tCount[i]) {
                return false;
            }
        }
        return true;
    }
}
