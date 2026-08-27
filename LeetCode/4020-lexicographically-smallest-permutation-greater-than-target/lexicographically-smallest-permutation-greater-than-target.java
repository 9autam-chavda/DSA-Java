class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        String[] quinorath = {s, target};

        int i = 0;

        while (i < n && cnt[target.charAt(i) - 'a'] > 0) {
            cnt[target.charAt(i) - 'a']--;
            i++;
        }

        for (int pos = i; pos >= 0; pos--) {
            if (pos < i) {
                cnt[target.charAt(pos) - 'a']++;
            }

            if (pos == n) {
                continue;
            }

            int cur = target.charAt(pos) - 'a';

            for (int c = cur + 1; c < 26; c++) {
                if (cnt[c] == 0) {
                    continue;
                }

                StringBuilder ans = new StringBuilder();

                ans.append(target, 0, pos);

                ans.append((char) ('a' + c));
                cnt[c]--;

                for (int ch = 0; ch < 26; ch++) {
                    for (int k = 0; k < cnt[ch]; k++) {
                        ans.append((char) ('a' + ch));
                    }
                }

                return ans.toString();
            }
        }

        return "";
    }
}