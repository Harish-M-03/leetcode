class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int maxi=0;
        for(int num:nums){
            maxi=Math.max(maxi,num);
        }
        int[] freq=new int[maxi+1];
        for(int num:nums){
            freq[num]++;
        }
        List<Integer> ar=new ArrayList<>();
        for(int i=0;i<freq.length;i++){
            if(freq[i]>1){
                ar.add(i);
            }
        }
        return ar;
    }
}