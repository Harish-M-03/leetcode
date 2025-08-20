class Solution {
    private int capacity(int[] arr,int mid){
        int total=0,daycount=1;
        for(int num:arr){
            if(total+num>mid){
                daycount++;
                total=0;
            }
            total+=num;
        }
        return daycount;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxi=0;
        int mxnum=0;
        for(int num:weights){
            maxi+=num;
            mxnum=Math.max(mxnum,num);
        }
        int left=mxnum,right=maxi,ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int res=capacity(weights,mid);
            if(res<=days){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}