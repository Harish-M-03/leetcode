class Solution {
    private int split(int[] nums,int mid){
        int part=1,sum=0;
        for(int num:nums){
            if(sum+num<=mid){
                sum+=num;
            }else{
                part++;
                sum=num;
            }
        }
        return part;
    }
    public int splitArray(int[] nums, int k) {
        if(k>nums.length){
            return -1;
        }
        int low=0,high=0,ans=-1;
        for(int num:nums){
            low=Math.max(low,num);
            high+=num;
        }
    while(low<=high){
        int mid=low+(high-low)/2;
        int res=split(nums,mid);
        if(res<=k){
            ans=mid;
            high=mid-1;
        }else{
            low=mid+1;
        }
    }
    return ans;
    }
}