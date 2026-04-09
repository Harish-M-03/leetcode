class Solution {
    public String reverseVowels(String s) {
        String vowels="aeiouAEIOU";
        String v="";
        for(char ch:s.toCharArray()){
            if(vowels.indexOf(ch)!=-1){
                v+=ch;
            }
        }
        StringBuilder str=new StringBuilder(s);
        StringBuilder vow=new StringBuilder(v);
        v=vow.reverse().toString();
        int k=0;
        for(int i=0;i<s.length();i++){
            if(vowels.indexOf(s.charAt(i))!=-1){
                str.setCharAt(i,v.charAt(k));
                k++;
            }
        }
        return str.toString();
    }
}