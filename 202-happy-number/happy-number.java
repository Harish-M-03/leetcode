class Solution {
    private int Happy(int num){
        int temp=num;
        int sum=0;
        while(temp!=0){
            int dig=temp%10;
            sum=sum+(dig*dig);
            temp=temp/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int num=n;
        HashSet<Integer> seen=new HashSet<>();
        while(num!=1&&!seen.contains(num)){
            seen.add(num);
            num=Happy(num);
        }
        return num==1;
    }
}