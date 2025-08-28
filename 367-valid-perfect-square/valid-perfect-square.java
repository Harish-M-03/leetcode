class Solution {
    public boolean isPerfectSquare(int num) {
        int left=1,right=num;
        long res=0;
        while(left<=right){
            long mid=left+(right-left)/2;
            long ans=mid*mid;
            if(ans==num){
                res=ans;
                break;
            }
            if(ans<num){
                left=(int)mid+1;
            }else{
                right=(int)mid-1;
            }
        }
        if((int)res==num){
            return true;
        }
        return false;
    }
}