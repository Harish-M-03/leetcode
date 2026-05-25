class Solution {
    public String replaceDigits(String s) {
        String str="";
        str+=s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int n=s.charAt(i)-'0';
                int ascii=(s.charAt(i-1)+n);
                str+=(char)ascii;
            }else{
                str+=s.charAt(i);
            }
        }
        return str;
    }
}