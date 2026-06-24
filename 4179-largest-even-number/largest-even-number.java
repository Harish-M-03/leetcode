class Solution {
    public String largestEven(String s) {
        String prefix=s;
        while(prefix.length()!=0){
            char ch=prefix.charAt(prefix.length()-1);
            int num=ch-'0';
            if(num%2==0){
                return prefix;
            }
            prefix=prefix.substring(0,prefix.length()-1);
        }
        return "";
    }
}