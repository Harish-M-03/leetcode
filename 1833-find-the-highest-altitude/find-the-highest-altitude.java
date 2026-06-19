class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int[] prefix=new int[n+1];
        int k=1,maxi=prefix[0];
        int len=n+1;
        while(k<len){
            prefix[k]=prefix[k-1]+gain[k-1];
            maxi=Math.max(maxi,prefix[k]);
            k++;
        }
        return maxi;
    }
}