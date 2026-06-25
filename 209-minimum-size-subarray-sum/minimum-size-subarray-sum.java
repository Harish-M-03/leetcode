class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int mini=Integer.MAX_VALUE;
        int len=0;
        int sum=0,left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                int l=right-left+1;
                if(mini>l){
                    mini=l;
                    len=l;
                }
                sum=sum-nums[left];
                left++;
            }
        }
        return len;
    }
}