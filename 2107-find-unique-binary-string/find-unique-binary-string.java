class Solution {
    private String ConvertString(int num,int n){
        StringBuilder st=new StringBuilder();
        while(num!=0){
            int dig=num%2;
            st.append(Integer.toString(dig));
            num=num/2;
        }
        String s=st.reverse().toString();
        while(s.length()<n){
            s="0"+s;
        }
        return s;
    }
    public String findDifferentBinaryString(String[] nums) {
        String st=nums[0];
        int n=st.length();
        ArrayList<String> arr=new ArrayList<>();
        for(String s:nums){
            arr.add(s);
        }
        int num=(int)Math.pow(2,n);
        for(int i=0;i<num;i++){
            String s=ConvertString(i,n);
            if(!arr.contains(s)){
                return s;
            }
        }
        return " ";
    }
}