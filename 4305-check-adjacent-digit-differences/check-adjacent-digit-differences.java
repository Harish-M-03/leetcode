class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        for(int i=1;i<s.length();i++){
            int num1=s.charAt(i-1)-'0';
            int num2=s.charAt(i)-'0';
            if(Math.abs(num1-num2)>2){
                return false;
            }
        }
        return true;
    }
}