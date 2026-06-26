class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum=0,maxi=Integer.MAX_VALUE,len=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                int l=right-left+1;
                if(maxi>l){
                    maxi=l;
                    len=l;
                }
                sum=sum-nums[left];
                left++;
            }
        }
        return len;
    }
}