class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] result=new int[k];
        int i=0;
        while(k!=0){
            int maxi=Integer.MIN_VALUE;
            int number=0;
            for(int num:map.keySet()){
                if(maxi<map.get(num)){
                    maxi=map.get(num);
                    number=num;
                }
            }
            result[i++]=number;
            map.remove(number);
            k--;
        }
        return result;
    }
}