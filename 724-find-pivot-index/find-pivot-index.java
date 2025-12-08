class Solution {
    private long sumofNum(int left,int right,int[] nums){
        long sum=0;
        for(int i=left;i<=right;i++){
            sum+=nums[i];
        }
        return sum;
    } 
    public int pivotIndex(int[] nums) {
        int low=0,high=nums.length-1;
        for(int i=0;i<nums.length;i++){
            long leftsum = sumofNum(low, i - 1, nums);
            long rightsum = sumofNum(i + 1, high, nums); 
            if(leftsum==rightsum){
                return i;
            }
        }
        return -1;
    }
}