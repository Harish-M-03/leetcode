class Solution {
    public String processStr(String s) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>=97&&ch<=122){
                str.append(ch);
            }else if(str.length()>0&&ch=='*'){
                str.deleteCharAt(str.length()-1);
            }else if(str.length()>0&&ch=='#'){
                str.append(str.toString());
            }else if(ch=='%'){
                str.reverse();
            }
        }
        return str.toString();
    }
}