class Solution {
    private int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public int findGCD(int[] nums) {
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        for(int num:nums){
            mini=Math.min(mini,num);
            maxi=Math.max(maxi,num);
        }
        return gcd(mini,maxi);
    }
}