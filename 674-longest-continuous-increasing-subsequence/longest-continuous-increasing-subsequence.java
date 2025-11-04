class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;

        int maxi = 1, currLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currLen++;
            } else {
                currLen = 1;
            }
            maxi = Math.max(maxi, currLen);
        }
        return maxi;
    }
}
