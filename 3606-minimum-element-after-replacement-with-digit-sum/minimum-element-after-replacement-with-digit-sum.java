class Solution {
    private int singledigit(int num){
        int sum=0;
        while(num!=0){
            sum=sum+num%10;
            num=num/10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int mini=Integer.MAX_VALUE;
        for(int num:nums){
            int sum=singledigit(num);
            mini=Math.min(mini,sum);
        }
        return mini;
    }
}