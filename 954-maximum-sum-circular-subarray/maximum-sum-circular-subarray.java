class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        int maxsum=Integer.MIN_VALUE;
        int curmax=0;
        int minsum=Integer.MAX_VALUE;
        int curmin=0;
        for(int num:nums){
            curmax=Math.max(curmax+num,num);
            maxsum=Math.max(maxsum,curmax);
            curmin=Math.min(curmin+num,num);
            minsum=Math.min(minsum,curmin);
            total+=num;
        }
        if(maxsum<0){
            return maxsum;
        }
        return Math.max(maxsum,total-minsum);
    }
}