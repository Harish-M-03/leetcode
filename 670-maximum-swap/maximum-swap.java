class Solution {

    private int maxnum(String str,int i,int j){
        StringBuilder st=new StringBuilder(str);
        char ch1=str.charAt(i);
        char ch2=str.charAt(j);
        st.setCharAt(i,ch2);
        st.setCharAt(j,ch1);
        return Integer.parseInt(st.toString());
    }

    public int maximumSwap(int num) {

        String st = Integer.toString(num);

        // only single digit needs early return
        if(st.length()==1) return num;

        int maxi = num;   // include original number

        for(int i=0;i<st.length();i++){
            for(int j=i+1;j<st.length();j++){
                int n = maxnum(st,i,j);
                maxi = Math.max(maxi,n);
            }
        }

        return maxi;
    }
}