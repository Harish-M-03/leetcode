class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result=new int[nums.length];
        int n=nums.length;
        for(int i=0;i<n;i++){
            int maxi=-1;
            for(int j=i;j<i+n;j++){
                if(nums[i]<nums[j%n]){
                    maxi=nums[j%n];
                    break;
                }
            }
            result[i]=maxi;
        }
        return result;
    }
}