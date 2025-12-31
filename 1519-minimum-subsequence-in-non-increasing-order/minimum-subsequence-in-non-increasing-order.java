class Solution {
    public List<Integer> minSubsequence(int[] nums) {

        // Sort ascending
        Arrays.sort(nums);

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        List<Integer> result = new ArrayList<>();
        int currSum = 0;

        // Pick from largest to smallest
        for (int i = nums.length - 1; i >= 0; i--) {
            currSum += nums[i];
            result.add(nums[i]);

            if (currSum > totalSum - currSum) {
                break;
            }
        }

        // Already in non-increasing order
        return result;
    }
}
