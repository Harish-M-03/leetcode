class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxi=Double.MIN_VALUE;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double maxavg=(double)sum/k;
        for(int i=k;i<nums.length;i++){
            sum=sum+nums[i]-nums[i-k];
            double avg=(double)sum/k;
            if(maxavg<avg){
                maxavg=avg;
            }
        }
        return maxavg;
    }
}