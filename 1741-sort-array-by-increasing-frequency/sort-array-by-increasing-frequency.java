class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] result=new int[nums.length];
        int k=0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        while(!map.isEmpty()){
            int minfreq=Integer.MAX_VALUE;
            int key=Integer.MIN_VALUE;
            for(int num:map.keySet()){
                if(minfreq>map.get(num)||(minfreq==map.get(num)&&key<num)){
                    minfreq=map.get(num);
                    key=num;
                }
            }
            for(int i=0;i<minfreq;i++){
                result[k++]=key;
            }
            map.remove(key);
        }
        return result;
    }
}