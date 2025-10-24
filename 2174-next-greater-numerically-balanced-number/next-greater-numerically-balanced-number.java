class Solution {
    private boolean beautiful(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:map.keySet()){
            int num=ch-'0';
            if(num!=map.get(ch)){
                return false;
            }
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while(true){
            String str = Integer.toString(num);
            if(beautiful(str)){
                return num;
            }
            num++;
        }
    }
}