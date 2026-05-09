class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int[] freq=new int[max+1];
        for(int num:nums){
            freq[num]++;
        }
        int prev=0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                int temp = freq[i];
                freq[i] = prev;
                prev += temp;
            }
        }
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=freq[nums[i]];
        }
        return result;
    }
}