class Solution {
    public int missingMultiple(int[] nums, int k) {
        ArrayList<Integer> ar=new ArrayList<>();
        int i=1;
        for(int num:nums){
            ar.add(num);
        }
        while(true){
            int n=k*i;
            if(!ar.contains(n)){
                return n;
            }
            i++;
        }
    }
}