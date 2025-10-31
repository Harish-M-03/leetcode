import java.util.*;

class Solution {

    // Helper function not needed for this optimized approach, but we'll keep your structure idea
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int mod = 1_000_000_007;

        // Precompute powers of 2 (same as recursion combinations count)
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }

        int left = 0, right = n - 1;
        long count = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // Equivalent of all possible subsets between left..right
                count = (count + pow2[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return (int) count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        System.out.println("Count: " + sol.numSubseq(nums, target)); // Expected output: 4
    }
}
