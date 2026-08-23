class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int s1 = 0, s2 = 0;
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                cnt1++;
            } else {
                s1 += c - '0';
            }
        }

        for (int i = half; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                cnt2++;
            } else {
                s2 += c - '0';
            }
        }

        if (((cnt1 + cnt2) & 1) == 1) {
            return true;
        }

        return s1 - s2 != 9 * (cnt2 - cnt1) / 2;
    }
}