class Solution {
    private int convertnum(String st){
        int result=0;
        for(int i=0;i<st.length();i++){
            result=result*2+(st.charAt(i)-'0');
        }
        return result;
    }
    public int bitwiseComplement(int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return 0;
        }
        int temp=n;
        int sum=0;
        StringBuilder str=new StringBuilder(); 
        while(temp!=0){
            int dig=temp%2;
            if(dig==1){
                str.append("0");
            }else{
                str.append("1");
            }
            temp=temp/2;
        }
        String res=str.reverse().toString();
        int result=convertnum(res);
        return result;
    }
}