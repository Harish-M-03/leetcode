class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int result=0;
        for(int num:set){
            if(num>0){
                result+=num;
            }
        }
        if(result==0){
            return Collections.max(set);
        }
        return result;
    }
}