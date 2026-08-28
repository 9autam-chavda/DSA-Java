class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        String calendrix = s;
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) cnt[c - 'a']++;

        int odd = 0;
        for (int x : cnt) {
            if ((x & 1) != 0) odd++;
        }

        if (odd > 1) return "";

        int[] half = new int[26];
        for (int i = 0; i < 26; i++) half[i] = cnt[i] / 2;

        int m = n / 2;

        StringBuilder left = new StringBuilder();
        int[] rem = half.clone();

        for (int i = 0; i < m; i++) {
            int x = target.charAt(i) - 'a';
            if (rem[x] == 0) break;
            left.append((char) ('a' + x));
            rem[x]--;
        }

        if (left.length() == m) {
            String p = build(left.toString(), cnt, n);
            if (p.compareTo(target) > 0) return p;
        }

        for (int i = Math.min(left.length(), m - 1); i >= 0; i--) {
            int[] cur = half.clone();

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';
                if (cur[x] == 0) {
                    cur = null;
                    break;
                }
                cur[x]--;
            }

            if (cur == null) continue;

            int x = target.charAt(i) - 'a';

            for (int c = x + 1; c < 26; c++) {
                if (cur[c] == 0) continue;

                StringBuilder l = new StringBuilder();
                l.append(target, 0, i);
                l.append((char) ('a' + c));
                cur[c]--;

                for (int k = 0; k < 26; k++) {
                    while (cur[k] > 0) {
                        l.append((char) ('a' + k));
                        cur[k]--;
                    }
                }

                return build(l.toString(), cnt, n);
            }
        }

        return "";
    }

    private String build(String left, int[] cnt, int n) {
        StringBuilder ans = new StringBuilder(left);

        if ((n & 1) != 0) {
            for (int i = 0; i < 26; i++) {
                if ((cnt[i] & 1) != 0) {
                    ans.append((char) ('a' + i));
                    break;
                }
            }
        }

        ans.append(new StringBuilder(left).reverse());
        return ans.toString();
    }
}