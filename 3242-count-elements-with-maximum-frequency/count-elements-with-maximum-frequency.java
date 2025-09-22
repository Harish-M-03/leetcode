class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int maxi=0;
        for(int num:nums){
            if(maxi<map.get(num)){
                maxi=map.get(num);
            }
        }
        int count=0;
        for(int num:nums){
            if(map.get(num)==maxi){
                count++;
            }
        }
        return count;
    }
}