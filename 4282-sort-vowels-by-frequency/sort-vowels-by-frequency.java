class Solution {
    private String sort(String str,int[] freq){
        String result="";
        StringBuilder s=new StringBuilder(str);
        while(s.length()!=0){
            int maxi=Integer.MIN_VALUE;
            char ch='\u0000';
            int ind=0;
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(freq[c-'a']>maxi){
                    maxi=freq[c-'a'];
                    ch=c;
                    ind=i;
                }
            }
            for(int i=0;i<maxi;i++){
                result+=ch;
            }
            s.deleteCharAt(ind);
        }
        return result;
    }
    public String sortVowels(String s) {
        int[] freq=new int[26];
        String vowels="aeiou";
        String str="",res="";
        for(char ch:s.toCharArray()){
            if(vowels.indexOf(ch)!=-1){
                freq[ch-'a']++;
                if(str.indexOf(ch)==-1){
                    str+=ch;
                }
            }
        }
        String result=sort(str,freq);
        int k=0;
        for(char ch:s.toCharArray()){
            if(vowels.indexOf(ch)!=-1){
                res+=result.charAt(k++);
            }else{
                res+=ch;
            }
        }
        return res;
    }
}