class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int i=1;
        int number=0;
        int maxi=Integer.MIN_VALUE;
        while(i!=0){
            for(int num:map.keySet()){
                if(maxi<map.get(num)){
                    number=num;
                    maxi=map.get(num);
                }
            }
            i--;
        }
        return number;
    }
}