class Solution {
    public boolean closeStrings(String word1, String word2) {
        boolean isValid=true;
        for(char ch:word1.toCharArray()){
            if(word2.indexOf(ch)==-1){
                isValid=false;
                break;
            }
        }
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(char ch:word1.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(char ch:word2.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        ArrayList<Integer> list1 = new ArrayList<>(map1.values());
        ArrayList<Integer> list2 = new ArrayList<>(map2.values());
        Collections.sort(list1);
        Collections.sort(list2);
        return isValid&&list1.equals(list2);
    }
}