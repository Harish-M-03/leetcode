class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq=new int[26];
        for(char chr:s.toCharArray()){
           freq[chr-'a']++;
        }
        for(char ch:t.toCharArray()){
            if(--freq[ch-'a']<0){
                return ch;
            }
        }
        return '\0';
    }
}