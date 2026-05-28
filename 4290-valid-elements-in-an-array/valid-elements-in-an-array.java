class Solution {
    private boolean isValid(int n,int[] nums){
        boolean left=true;
        boolean right=true;
        for(int i=0;i<n;i++){
            if(nums[n]<=nums[i]){
                left=false;
                break;
            }
        }
        for(int i=n+1;i<nums.length;i++){
            if(nums[n]<=nums[i]){
                right=false;
                break;
            }
        }
        return left||right;
    }
    public List<Integer> findValidElements(int[] nums) {
      List<Integer> arr=new ArrayList<>();
       if(nums.length<2){
            for(int i=0;i<nums.length;i++){
                arr.add(nums[i]);
            }
       }else{
       arr.add(nums[0]);
       for(int i=1;i<nums.length-1;i++){
            if(isValid(i,nums)){
                arr.add(nums[i]);
            }
       }
       arr.add(nums[nums.length-1]);
       }
       return arr;
    }
}