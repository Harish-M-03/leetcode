class Solution {
    public int concatenatedBinary(int n) {
       long result=0;
       int MOD=1000000007;
       for(int i=1;i<=n;i++){
            int temp=i;
            int bits=0;
            while(temp>0){
                bits++;
                temp=temp>>1;
            }
            result=((result<<bits)+i)%MOD;
       }
       return (int)result;
    }
}