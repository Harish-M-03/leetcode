class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            boolean left=true;
            boolean right=true;
            if(i>0&&nums[i-1]>nums[i]){
                left=false;
            }
            if(i<n-1&&nums[i+1]>nums[i]){
                right=false;
            }
            if(left&&right){
                return i;
            }
        }
        return -1;
    }
}