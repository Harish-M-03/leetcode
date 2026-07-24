class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int maxi=0;
        for(int i=1;i<nums.length;i++){
            int j=i-1;
            while(j>=0){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                j=j-1;
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}