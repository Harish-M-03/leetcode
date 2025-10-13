class Solution { 
    private boolean isEqual(String st1,String st2){
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(char ch:st1.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(char ch:st2.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        if(map1.equals(map2)){
            return true;
        }
        return false;
    }
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> arr=new ArrayList<>();
        arr.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(isEqual(words[i],arr.get(arr.size()-1))){
                continue;
            }else{
                arr.add(words[i]);
            }
        }
        return arr;
    }
}