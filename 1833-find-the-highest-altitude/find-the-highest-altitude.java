class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int[] prefix=new int[n+1];
        prefix[0]=0;
        for(int i=1;i<n+1;i++){
            prefix[i]=gain[i-1]+prefix[i-1];
        }
        int maxi=Integer.MIN_VALUE;
        for(int num:prefix){
            maxi=Math.max(maxi,num);
        }
        return maxi;
    }
}