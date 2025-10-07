class Solution {
    private boolean isPrime(int num){
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
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> arr=new ArrayList<>();
        while(left<=right){
            if(isPrime(left)){
                arr.add(left);
            }
            left++;
        }
        int[] res={-1,-1};
        if(arr.size()<=1){
            return res;
        }
        int mini=Integer.MAX_VALUE; 
        for(int i=1;i<arr.size();i++){
            int diff=arr.get(i)-arr.get(i-1);
            if(diff<mini){
                mini=diff;
                res[0]=arr.get(i-1);
                res[1]=arr.get(i);
            }
        }
        return res;
    }
}