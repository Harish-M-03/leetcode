class Solution {
    public int minimumDistance(int[] nums) {
        if(nums.length<3){
            return -1;
        }
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            ArrayList<Integer> ar=new ArrayList<>();
            ar.add(i);
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    ar.add(j);
                }
            }
            arr.add(ar);
        }
        int mini=Integer.MAX_VALUE;
        for(ArrayList<Integer> ar:arr){
            if(ar.size()>=3){
                for(int i = 0; i <= ar.size() - 3; i++) {
                    int i1 = ar.get(i);
                    int i2 = ar.get(i + 1);
                    int i3 = ar.get(i + 2);
                    int sum = Math.abs(i1 - i2) + Math.abs(i2 - i3) + Math.abs(i1 - i3);
                    mini = Math.min(mini, sum);
}
            }
        }
        if(mini!=Integer.MAX_VALUE){
            return mini;
        }
        return -1;
    }
}