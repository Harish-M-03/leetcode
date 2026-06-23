class Solution {
    private String GenerateString(int n,int ind){
        StringBuilder str=new StringBuilder();
        int temp=ind;
        while(temp!=0){
            int dig=temp%2;
            str.append(Integer.toString(dig));
            temp=temp/2;
        }
        String s=str.reverse().toString();
        while(s.length()<n){
            s="0"+s;
        }
        return s;
    }
    private boolean check(String st,int k){
        boolean together=true;
        int cost=0;
        for(int i=1;i<st.length();i++){
            if(st.charAt(i)=='1'){
                cost+=i;
            }
            if(i>0&&st.charAt(i)=='1'&&st.charAt(i-1)=='1'){
                together=false;
                break;
            }
        }
        return cost<=k&&together;
    }
    public List<String> generateValidStrings(int n, int k) {
        int num=(int)Math.pow(2,n);
        List<String> ar=new ArrayList<>();
        for(int i=0;i<num;i++){
            String st=GenerateString(n,i);
            if(check(st,k)){
                ar.add(st);
            }
        }
        return ar;
    }
}