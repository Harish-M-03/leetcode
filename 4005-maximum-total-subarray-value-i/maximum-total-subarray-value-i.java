class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long sum=0;
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        for(int num:nums){
            mini=Math.min(mini,num);
            maxi=Math.max(maxi,num);
        }
        while(k!=0){
            sum+=(maxi-mini);
            k--;
        }
        return sum;
    }
}