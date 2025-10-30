class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int index=-1;
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                index=i;
                break;
            }
        }
        return index;
    }
}