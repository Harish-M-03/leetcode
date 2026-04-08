class Solution {
    private int GCD(int a,int b){
        if(b==0){
            return a;
        }
        return GCD(b,a%b); 
    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int gcd=GCD(str1.length(),str2.length());
        String result=str1.substring(0,gcd);
        return result;
    }
}