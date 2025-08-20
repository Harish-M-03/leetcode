class Solution {
    private int mbouquets(int[] arr,int mid,int k){
        int tot=0;
        int numboq=0;
        for(int num:arr){
            if(num<=mid){
                tot++;
                if(tot==k){
                     numboq+=1;
                     tot=0;
                }
               
            }else{
                tot=0;
            }
        }
        return numboq;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int maxi=0;
        for(int num:bloomDay){
            maxi=Math.max(maxi,num);
        }
        int left=1,right=maxi,ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int res=mbouquets(bloomDay,mid,k);
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