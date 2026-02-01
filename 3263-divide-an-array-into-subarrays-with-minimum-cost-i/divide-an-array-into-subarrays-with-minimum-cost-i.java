class Solution {
    public int minimumCost(int[] nums) {
        int count=nums[0];
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        arr.remove(0);
        int k=0;
        while(k<2){
            int mini=Integer.MAX_VALUE;
            int j=0;
            for(int i=0;i<arr.size();i++){
                if(mini>arr.get(i)){
                    mini=arr.get(i);
                    j=i;
                }
            }
            count+=mini;
            arr.remove(j);
            k++;
        }
        return count;
    }
}