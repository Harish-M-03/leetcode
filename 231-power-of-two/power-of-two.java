class Solution {
    private long powtwo(int exp) {
        long ans = 1;
        for (int i = 1; i <= exp; i++) {
            ans *= 2;
        }
        return ans; // return 2^exp
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int left = 0, right = 31; // because 2^31 > Integer.MAX_VALUE
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long val = powtwo(mid);
            if (val == n) return true;
            else if (val < n) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
