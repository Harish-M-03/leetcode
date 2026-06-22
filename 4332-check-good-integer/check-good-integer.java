class Solution {
    public boolean checkGoodInteger(int n) {
        int sum=0;
        int square=0;
        int temp=n;
        while(temp!=0){
            int dig=temp%10;
            square+=(dig*dig);
            sum+=dig;
            temp=temp/10;
        }
        int result=square-sum;
        return result>=50;
    }
}