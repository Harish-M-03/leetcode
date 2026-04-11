class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> zeros=new ArrayList<>();
        for(int num:nums){
            if(num==0){
                zeros.add(num);
            }else{
                pos.add(num);
            }
        }
        int i=0;
        for(int j=0;j<pos.size();j++){
            nums[i++]=pos.get(j);
        }
        for(int j=0;j<zeros.size();j++){
            nums[i++]=zeros.get(j);
        }
    }
}