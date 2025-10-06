class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int i=0;
        int[] res=new int[k];
        while(i<k){
            int maxkey=0;
            int maxval=0;
            int j=0;
            for(int num:map.keySet()){
                if(map.get(num)>maxval){
                    maxkey=num;
                    maxval=map.get(num);
                }
            }
            res[i]=maxkey;
            map.remove(maxkey);
            i++;
        }
        return res;
    }
}