class Solution {
    public int minimumDifference(int[] nums, int k) {
       Arrays.sort(nums);
       int mini=Integer.MAX_VALUE;
       for(int i=0;i+k-1<nums.length;i++){
            mini=Math.min(mini,nums[i+k-1]-nums[i]);
       }
       return mini;
    }
}