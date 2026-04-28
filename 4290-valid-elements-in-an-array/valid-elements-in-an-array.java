class Solution {
    private boolean isValid(int left,int right,int[] nums,int element){
        boolean isvalid=true;
        for(int i=left;i<right;i++){
            if(nums[i]>=element){
                isvalid=false;
                break;
            }
        }
        return isvalid;
    }
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums.length<=2){
            for(int num:nums){
                res.add(num);
            }
        }
        else{
        List<Integer> arr=new ArrayList<>();
        for(int i=1;i<nums.length-1;i++){
            if(isValid(0,i,nums,nums[i])||isValid(i+1,nums.length,nums,nums[i])){
                arr.add(nums[i]);
            }
        }
        res.add(nums[0]);
        for(int num:arr){
            res.add(num);
        }
        res.add(nums[nums.length-1]);
        }
        return res;
    }
}