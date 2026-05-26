class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
        int[] lower=new int[26];
        int[] upper=new int[26];
        for(char ch:word.toCharArray()){
            if(ch>=65&&ch<=90){
                upper[ch-'A']++;
            }else if(ch>=97&&ch<=122){
                lower[ch-'a']++;
            }
        }
        for(int i=0;i<26;i++){
            if(upper[i]>0&&lower[i]>0){
                count++;
            }
        }
        return count;
    }
}