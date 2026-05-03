class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        int n=s.length();
        boolean isTrue=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==goal.charAt(0)){
                int k=0;
                boolean isValid=true;
                for(int j=i;j<i+n;j++){
                    if(s.charAt(j%n)!=goal.charAt(k++)){
                        isValid=false;
                        break;
                    }
                }
                if(isValid){
                    isTrue=true;
                    break;
                }
            }
        }
        return isTrue;
    }
}