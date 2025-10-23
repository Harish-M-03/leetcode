class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        int left = 0, right = 20; // since 3^20 > 10^9, good range for int

        while (left <= right) {
            int mid = left + (right - left) / 2;
            double val = Math.pow(3, mid);

            if (val == n) return true;
            else if (val < n) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
