class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==1||nums.length==0){
            return nums.length;
        }
        Arrays.sort(nums);
        int count=1,maxlen=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                continue;
            }
            else if(nums[i]-nums[i-1]==1){
                count+=1;
            }else{
                maxlen=Math.max(maxlen,count);
                count=1;
            }
        }
        return Math.max(maxlen,count);
    }
}