class Solution {
    private String generate(int num,int length){
        StringBuilder str=new StringBuilder();
        while(num!=0){
            int dig=num%2;
            str.append(Integer.toString(dig));
            num=num/2;
        }
        String s=str.reverse().toString();
        while(s.length()<length){
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
        int size=(int)Math.pow(2,n);
        for(int i=0;i<size;i++){
            String s=generate(i,n);
            if(!arr.contains(s)){
                return s;
            }
        }
        return " ";
    }
}