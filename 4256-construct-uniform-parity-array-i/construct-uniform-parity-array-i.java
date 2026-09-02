class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean isOdd=false;
        boolean isEven=false;
        for(int n:nums1){
            if(n%2==0){
                isEven=true;
            }else{
                isOdd=true;
            }
        }
        return isEven||isOdd;
    }
}