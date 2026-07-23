class Solution {
    private int findshipdays(int[] weights,int mid){
        int total=0,days=1;
        for(int num:weights){
            if(total+num>mid){
                days++;
                total=0;
            }
            total+=num;
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxi=0;
        int mini=Integer.MIN_VALUE;
        for(int num:weights){
            maxi+=num;
            mini=Math.max(mini,num);
        }
        int left=mini,right=maxi,ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int res=findshipdays(weights,mid);
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