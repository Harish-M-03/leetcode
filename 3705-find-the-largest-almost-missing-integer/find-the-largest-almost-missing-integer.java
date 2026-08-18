class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<=n-k;i++){
            int j=i;
            HashSet<Integer> set=new HashSet<>();
            while(j<i+k){
                set.add(nums[j]);
                j++;
            }
            for(int num:set){
                map.put(num,map.getOrDefault(num,0)+1);
            }      
        }
        int maxi=-1;
        for(int num:map.keySet()){
            if(map.get(num)==1){
                maxi=Math.max(maxi,num);
            }
        }
        return maxi;
    }
}