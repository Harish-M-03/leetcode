class Solution {
    public int passwordStrength(String password) {
        String str="";
        for(char ch:password.toCharArray()){
            if(str.indexOf(ch)==-1){
                str+=ch;
            }
        }
        int count=0;
        for(char ch:str.toCharArray()){
            if(ch>=65&&ch<=90){
                count+=2;
            }else if(ch>=97&&ch<=122){
                count+=1;
            }else if(Character.isDigit(ch)){
                count+=3;
            }else{
                count+=5;
            }
        }
        return count;
    }
}