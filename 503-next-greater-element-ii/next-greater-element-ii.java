class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            int next=-1;
            for(int j=i+1;j<i+n;j++){
                if(nums[i]<nums[j%n]){
                    next=nums[j%n];
                    break;
                }
            }
            result[i]=next;
        }
        return result;
    }
}