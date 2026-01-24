class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1,maxi=Integer.MIN_VALUE;
        while(i<j){
            maxi=Math.max(maxi,nums[i]+nums[j]);
            i++;
            j--;
        }
        return maxi;    
    }
}