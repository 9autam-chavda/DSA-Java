class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        int[] tCount = new int[128];
        int[] sCount = new int[128];

        int need = 0;
        for (int i = 0; i < t.length(); i++) {
            if (tCount[t.charAt(i)] == 0) {
                need++; 
            }
            tCount[t.charAt(i)]++;
        }

        int left = 0;
        int have = 0; 
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            sCount[rightChar]++;

            if (tCount[rightChar] > 0 && sCount[rightChar] == tCount[rightChar]) {
                have++;
            }

            while (have == need) {
                int currentWindowLen = right - left + 1;
                if (currentWindowLen < minLen) {
                    minLen = currentWindowLen;
                    startIdx = left;
                }

                char leftChar = s.charAt(left);
                sCount[leftChar]--;

                if (tCount[leftChar] > 0 && sCount[leftChar] < tCount[leftChar]) {
                    have--;
                }
                
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
