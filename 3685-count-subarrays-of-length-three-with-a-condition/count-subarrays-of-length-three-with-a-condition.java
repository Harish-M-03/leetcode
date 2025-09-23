class Solution {
    public int countSubarrays(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length&&i+2<nums.length;i++){
            int num=nums[i]+nums[i+2];
            int res=num*2;
            if(res==nums[i+1]){
                count++;
            }
        }
        return count;
    }
}