class Solution {
    private String convert(int num){
        StringBuilder str=new StringBuilder();
        while(num>0){
            num--;
            char ch=(char)('A'+num%26);
            str.insert(0,ch);
            num=num/26;
        }
        return str.toString();
    }
    public String convertToTitle(int columnNumber) {
        String str=convert(columnNumber);
        return str; 
    }
}