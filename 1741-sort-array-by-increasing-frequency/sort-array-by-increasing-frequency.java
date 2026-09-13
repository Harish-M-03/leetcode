class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] result=new int[nums.length];
        int k=0;
        while(!map.isEmpty()){
            int mini=Integer.MAX_VALUE;
            int number=0;
            for(int num:map.keySet()){
                if(mini>map.get(num)||(map.get(num)==mini&&number<num)){
                    mini=map.get(num);
                    number=num;
                }
            }
            for(int i=0;i<mini;i++){
                result[k++]=number;
            }
            map.remove(number);
        }
        return result;
    }
}