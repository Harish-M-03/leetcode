class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        List<String> res=new ArrayList<>();
        int i=0;
        while(i<k){
            int maxfreq=0;
            String maxString="";
            for(String str:map.keySet()){
                if(maxfreq<map.get(str)){
                    maxfreq=map.get(str);
                    maxString=str;
                }else if (map.get(str) == maxfreq) {
                    if (str.compareTo(maxString) < 0) {
                        maxString = str;
                    }
                }

            }
            res.add(maxString);
            map.remove(maxString);
            i++;
        }
        return res;
    }
}