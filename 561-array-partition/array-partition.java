class Solution {
    public int arrayPairSum(int[] nums) {

        int maxi = nums[0];
        int mini = nums[0];

        for(int num : nums){
            maxi = Math.max(maxi, num);
            mini = Math.min(mini, num);
        }
        int[] freq = new int[maxi - mini + 1];
        for(int num : nums){
            freq[num - mini]++;
        }
        for(int i = 1; i < freq.length; i++){
            freq[i] = freq[i] + freq[i - 1];
        }

        int[] result = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){

            result[freq[nums[i] - mini] - 1] = nums[i];

            freq[nums[i] - mini]--;
        }

        int sum = 0;

        for(int i = 0; i < nums.length; i += 2){
            sum += result[i];
        }

        return sum;
    }
}