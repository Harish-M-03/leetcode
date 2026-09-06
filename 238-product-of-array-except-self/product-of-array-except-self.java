class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zerocnt=0,product=1;
        int[] pro=new int[nums.length];
        for(int num:nums){
            if(num!=0){
                product=product*num;
            }else{
                zerocnt++;
            }
        }
        if(zerocnt==0){
            for(int i=0;i<nums.length;i++){
                pro[i]=product/nums[i];
            }
        }else if(zerocnt==1){
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    pro[i]=product;
                }else{
                    pro[i]=0;
                }
            }
        }else{
            for(int i=0;i<nums.length;i++){
                pro[i]=0;
            }
        }
        return pro;
    }
}