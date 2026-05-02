class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int temp=i;
            boolean isValid=true;
            boolean isChanged=false;
            while(temp!=0){
                int dig=temp%10;
                if(dig==3||dig==4||dig==7){
                    isValid=false;
                    break;
                }
                if(dig==2||dig==5||dig==6||dig==9){
                    isChanged=true;
                }
                temp=temp/10;
            }
            if(isValid&&isChanged){
                count++;
            }
        }
        return count;
    }
}