class Solution {
    private boolean isValid(int num){
        if(num<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    private int NumberofSet(int num){
        int count=0;
        while(num!=0){
            count+=(num&1);
            num=num>>1;
        }
        return count;
    }
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        while(left<=right){
            int num=NumberofSet(left);
            if(isValid(num)){
                count++;
            }
            left++;
        }
        return count;
    }
}