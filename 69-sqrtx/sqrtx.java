class Solution {
    public int mySqrt(int x) {
        int low=1;
        int mid=-1;
        int end=x;
        while(low<=end){
            mid=low+(end-low)/2;
            if((long)mid*mid>(long)x){
                end=mid-1;
            }else if(mid*mid==x){
                return mid;
            }else{
                low=mid+1;
            }
        }
        return Math.round(end);
    }
}