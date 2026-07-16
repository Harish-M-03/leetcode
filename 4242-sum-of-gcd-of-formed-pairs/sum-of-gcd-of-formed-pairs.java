class Solution {
    private int gcd(int n1,int n2){
        if(n2==0){
            return n1;
        }
        return gcd(n2,n1%n2);
    }
    public long gcdSum(int[] nums) {
        int maxi=-1;
        int[] prefix=new int[nums.length];
        int k=0;
        for(int num:nums){
            maxi=Math.max(maxi,num);
            prefix[k++]=gcd(num,maxi);
        }
        Arrays.sort(prefix);
        int i=0,j=prefix.length-1,n=prefix.length;
        long sum=0;
        while(i<n/2){
            int n1=prefix[i];
            int n2=prefix[j];
            long num=(long)gcd(n1,n2);
            sum+=num;
            i++;
            j--;
        }
        return sum;
    }
}