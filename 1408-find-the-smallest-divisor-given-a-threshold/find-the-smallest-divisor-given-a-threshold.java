class Solution {
    private int dividend(int[] arr,int mid){
        int total=0;
        for(int num:arr){
            int div=(int) Math.ceil((double)num/mid);
            total+=div;
        }
        return total;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi=0;
        for(int num:nums){
            maxi=Math.max(maxi,num);
        }
        int left=1,right=maxi,ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int res=dividend(nums,mid);
            if(res<=threshold){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}