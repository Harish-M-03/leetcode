class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        boolean isValid=true;
        for(int num:map.values()){
            if(set.contains(num)){
                isValid=false;
                break;
            }else{
                set.add(num);
            }
        }
        return isValid;
    }
}