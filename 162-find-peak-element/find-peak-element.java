class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            boolean left=true;
            boolean right=true;
            if(i>0&&nums[i]<=nums[i-1]){
                left=false;
            }
            if(i<n-1&&nums[i]<=nums[i+1]){
                right=false;
            }
            if(left&&right){
                return i;
            }
        }
        return -1;
    }
}