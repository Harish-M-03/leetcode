class Solution {
    private int leftsum(int[] nums,int j,int n){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        return sum;
    }
    private int rightsum(int[] nums,int j,int n){
        int sum=0;
        for(int i=j;i<n;i++){
            sum+=nums[i];
        }
        return sum;
    }
    public int[] leftRightDifference(int[] nums) {
        int[] num=new int[nums.length];
        num[0]=rightsum(nums,1,nums.length);
        for(int i=1;i<nums.length-1;i++){
            int r=rightsum(nums,i+1,nums.length);
            int l=leftsum(nums,0,i);
            num[i]=Math.abs(l-r);
        }
        num[nums.length-1]=leftsum(nums,0,nums.length-1);
        return num;
    }
}