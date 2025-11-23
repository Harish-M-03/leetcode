class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {
            int[] newDp = dp.clone();

            for (int r = 0; r < 3; r++) {
                if (dp[r] != Integer.MIN_VALUE) {
                    int newR = (r + num) % 3;
                    newDp[newR] = Math.max(newDp[newR], dp[r] + num);
                }
            }

            dp = newDp;
        }

        return dp[0];
    }
}
