class Solution {
    private boolean IsValid(String str){
        int result=str.charAt(str.length()-1)-'0';
        return result%2!=0;
    }
    public String largestOddNumber(String num) {
        if(IsValid(num)){
            return num;
        }
        String number=num;
        String result="";
        while(number.length()!=0){
            number=number.substring(0,number.length()-1);
            if(number.length()!=0&&IsValid(number)){
                result=number;
                break;
            }
        }
        return result;
    }
}