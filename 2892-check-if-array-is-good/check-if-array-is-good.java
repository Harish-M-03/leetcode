class Solution {
    public boolean isGood(int[] nums) {
        int maxi=0;
        for(int num:nums){
            maxi=Math.max(num,maxi);
        }
        int[] result=new int[maxi+1];
        int i=0,k=1;
        while(i<maxi){
            result[i++]=k++;
        }
        result[i++]=maxi;
        Arrays.sort(nums);
        int j=0,l=0;
        if(nums.length!=result.length){
            return false;
        }
        while(j<nums.length&&l<result.length){
            if(nums[j]!=result[l]){
                return false;
            }
            j++;
            l++;
        }
        return true;
    }
}