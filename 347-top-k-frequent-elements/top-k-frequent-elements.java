class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==1){
            return nums;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] result=new int[k];
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int i=0;
        while(k!=0){
            int maxfreq=0;
            int num=0;
            for(int key:map.keySet()){
                if(maxfreq<map.get(key)){
                    maxfreq=map.get(key);
                    num=key;
                }
            }
            result[i++]=num;
            map.remove(num);
            k--;
        }
        return result;
    }
}