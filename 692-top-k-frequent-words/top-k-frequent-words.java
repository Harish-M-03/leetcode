class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> arr=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        while(k!=0){
            String st="";
            int maxfreq=0;
            for(String key:map.keySet()){
                if(maxfreq<map.get(key)||(maxfreq==map.get(key)&&key.compareTo(st) < 0)){
                    maxfreq=map.get(key);
                    st=key;
                }
            }
            arr.add(st);
            map.remove(st);
            k--;
        }
        return arr;
    }
}