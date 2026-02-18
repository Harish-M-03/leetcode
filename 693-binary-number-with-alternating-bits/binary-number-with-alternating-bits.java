class Solution {
    private boolean isvalid(String str){
        boolean isalt=true;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                isalt=false;
                break;
            }
        }
        return isalt;
    }
    public boolean hasAlternatingBits(int n) {
        StringBuilder str=new StringBuilder();
        int temp=n;
        while(temp!=0){
            int dig=temp%2;
            str.append(Integer.toString(dig));
            temp=temp/2;
        }
        if(isvalid(str.toString())){
            return true;
        }
        return false;
    }
}