class Solution {
    public boolean isFascinating(int n) {
        String str="123456789";
        int num1=n*2;
        int num2=n*3;
        String st1=Integer.toString(n);
        String st2=Integer.toString(num1);
        String st3=Integer.toString(num2);
        String res=st1+st2+st3;
        boolean isValid=true;
        if (res.length() != 9) {
            return false;
        }
        if (res.indexOf('0') != -1) {
            isValid = false;
        }
        for(char ch:str.toCharArray()){
            if(res.indexOf(ch)==-1){
                isValid=false;
                break;
            }
        }
        return isValid;
    }
}