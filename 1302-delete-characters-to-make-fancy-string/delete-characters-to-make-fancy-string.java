class Solution {
    public String makeFancyString(String s) {
        StringBuilder str=new StringBuilder();
        for(char ch:s.toCharArray()){
            int len=str.length();
            if(len>=2&&ch==str.charAt(len-1)&&ch==str.charAt(len-2)){
                continue;
            }else{
                str.append(ch);
            }
        }
        return str.toString();
    }
}