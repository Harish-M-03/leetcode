class Solution {
    private int minimumdays(int[] bloomDay,int mid,int k){
        int total=0,numbouquets=0;
        for(int num:bloomDay){
            if(num<=mid){
                total++;
                if(total==k){
                    numbouquets++;
                    total=0;
                }
            }else{
                total=0;
            }
        }
        return numbouquets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int maxi=0;
        for(int num:bloomDay){
            maxi=Math.max(maxi,num);
        }
        int left=1,right=maxi,ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int res=minimumdays(bloomDay,mid,k);
            if(res>=m){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}