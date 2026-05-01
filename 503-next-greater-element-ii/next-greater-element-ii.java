class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result=new int[nums.length];
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            int next=-1;
            for(int j=i+1;j<i+n;j++){
                if(nums[j%n]>nums[i]){
                    next=nums[j%n];
                    break;
                }
            }
            result[i]=next;
        }
        return result;
    }
}