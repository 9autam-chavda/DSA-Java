class Solution {

    int[] tree;
    int x;

    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {

            int rem = num % k;

            long[] next = new long[k];

            next[rem] = 1;

            for (int r = 0; r < k; r++) {
                int newRem = (int) ((long) r * rem % k);
                next[newRem] += dp[r];
            }

            for (int r = 0; r < k; r++) {
                ans[r] += next[r];
            }

            dp = next;
        }

        return ans;
    }

    private int countPower(int num) {
        int count = 0;

        while (num % x == 0) {
            num /= x;
            count++;
        }

        return count;
    }

    private void build(int node, int left, int right, int[] nums) {

        if (left == right) {
            tree[node] = countPower(nums[left]);
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private void update(int node, int left, int right, int pos, int value) {

        if (left == right) {
            tree[node] = value;
            return;
        }

        int mid = left + (right - left) / 2;

        if (pos <= mid) {
            update(node * 2, left, mid, pos, value);
        } else {
            update(node * 2 + 1, mid + 1, right, pos, value);
        }

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private int query(int node, int left, int right, int ql, int qr) {

        if (qr < left || right < ql) {
            return 0;
        }

        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        return query(node * 2, left, mid, ql, qr) + query(node * 2 + 1, mid + 1, right, ql, qr);
    }
}