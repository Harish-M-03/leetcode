class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]+1==nums[i]){
                sum+=nums[i];
            }else{
                break;
            }
        }
        ArrayList<Integer> ar=new ArrayList<>();
        for(int n:nums){
            ar.add(n);
        }
        while(true){
            if(!ar.contains(sum)){
                return sum;
            }
            sum++;
        }
    }
}