class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0,maxi=0;
        for(int right=0;right<s.length();right++){
            while(map.containsKey(s.charAt(right))){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            maxi=Math.max(maxi,right-left+1);
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
        }
        return maxi;
    }
}