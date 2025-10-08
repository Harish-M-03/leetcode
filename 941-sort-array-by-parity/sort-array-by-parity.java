class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length==1){
            return nums;
        }
        ArrayList<Integer> even=new ArrayList<>();
        ArrayList<Integer> odd=new ArrayList<>();
        for(int num:nums){
            if(num%2==0){
                even.add(num);
            }else{
                odd.add(num);
            }
        }
        int[] parity=new int[nums.length];
        int j=0;
        for(int i=0;i<even.size();i++){
            parity[j++]=even.get(i);
        }
        for(int i=0;i<odd.size();i++){
            parity[j++]=odd.get(i);
        }
        return parity;
    }
}