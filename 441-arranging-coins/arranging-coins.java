class Solution {
    private long power(int mid){
        return (long) mid * (mid + 1) / 2;
    }
    public int arrangeCoins(int n) {
        int low=1,high=n,ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            long res=power(mid);
            if(res<=n){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}