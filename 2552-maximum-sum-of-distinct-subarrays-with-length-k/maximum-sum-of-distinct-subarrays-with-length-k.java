class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long windowsum = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < k; i++) {
            windowsum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        long maxi = 0;
        if (freq.size() == k) { // all distinct
            maxi = windowsum;
        }

        // Step 2: slide the window
        for (int i = k; i < nums.length; i++) {

            // add new element
            windowsum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            // remove outgoing element
            int out = nums[i - k];
            windowsum -= out;
            freq.put(out, freq.get(out) - 1);
            if (freq.get(out) == 0) freq.remove(out);

            // window size = k, check distinct
            if (freq.size() == k) {
                maxi = Math.max(maxi, windowsum);
            }
        }

        return maxi;
    }
}
