class Solution {
    private int countOnes(int num){
        int temp=num;
        int count=0;
        while(temp!=0){
            count+=(temp&1);
            temp=temp>>1;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        ArrayList<Integer> ar=new ArrayList<>();
        int[] res=new int[arr.length];
        for(int num:arr){
            ar.add(num);
        }
        int i=0;
        while(!ar.isEmpty()){
            int mini=Integer.MAX_VALUE;
            int num=0;
            for(int n:ar){
                int cnt=countOnes(n);
                if(mini>cnt||(cnt==mini)&&n<num){
                    mini=cnt;
                    num=n;
                }
            }
            res[i++]=num;
            ar.remove((Integer)num);
        }
        return res;
    }
}